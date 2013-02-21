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
	 * Service permettant l'intéraction avec la couche DAO.
	 */
	//@Autowired
	//private PersonneManager personneManager;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException
	{
		/** TODO **/
		return null;
	}
	
	/**
	 * @return le nom d'utilisateur de la personne connectée
	 */
	public static String getCurrentUserLogin()
	{
		User currentUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return currentUser.getUsername();
	}
	
	/**
	 * @return true si l'utilisateur connecté possède les droits d'administrateur, false sinon
	 */
	public static boolean isCurrentUserAdmin()
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
	
}