package gof.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gof.model.Personne;
import gof.model.Statut;

/**
 * Classe permettant la convertion de la classe Personne en UserDetails afin de pouvoir être traitée par le module Spring security
 * @author Alexandre Monties
 * @version 1.0
 */
@SuppressWarnings("deprecation")
@Service("userDetailsService")
public class CustomUserDetails implements UserDetailsService
{
	/**
	 * Service permettant l'intéraction avec la couche Service.
	 */
	@Autowired
	private PersonneManager personneManager;
	
	@Autowired
	private MentionManager mentionManager;
	
	@Autowired
	private ElemStructManager elemStructManager;
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException
	{
		Personne userToLoad = personneManager.findPersonByIdExt(arg0);
		
		if(userToLoad == null)
			throw new UsernameNotFoundException("The user " + arg0 + " has not been found.");
		
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

		Iterator<Statut> it = userToLoad.getStatuts().iterator();
		
		while(it.hasNext())
		{
			authorities.add(new GrantedAuthorityImpl(it.next().toString()));
		}

		User userConverted = new User(userToLoad.getIdext(), userToLoad.getPassword(),authorities);
		
		return userConverted;
	}
	
	/**
	 * @return le nom d'utilisateur de la personne connectée
	 */
	public String getCurrentUserLogin()
	{
		User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return currentUser.getUsername();
	}
	
	/**
	 * @return true si l'utilisateur connecté possède les droits d'administrateur, false sinon
	 */
	public boolean isCurrentUserAdmin()
	{
		User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Iterator<GrantedAuthority> iterator = currentUser.getAuthorities().iterator();
		
		while(iterator.hasNext())
		{
			if(iterator.next().getAuthority().equals("ROLE_ADMIN"))
				return true;
		}
		
		return false;
	}

	/**
	 * @return true si l'utilisateur connecté possède les droits d'edition sur la fiche dont le code est passé en parametre, false sinon
	 */
	public boolean isCurrentUserHasRightOn(String code)
	{
		Personne currentUser = personneManager.findPersonByIdExt(this.getCurrentUserLogin());
		
		HashSet<String> codesFiches = (HashSet<String>) personneManager.findAllCodesFiches(currentUser);
		
		if(codesFiches.contains(code))
			return true;
		
		return false;
	}
}