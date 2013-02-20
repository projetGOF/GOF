package gof.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Classe permettant la convertion de la classe Person en UserDetails afin de pouvoir être traitée par le module Spring security
 * @author Alexandre Monties
 * @version 0.1
 */
@Service("userDetailsService")
public class CustomUserDetails implements UserDetailsService
{

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String arg0)
			throws UsernameNotFoundException
	{
		throw new UsernameNotFoundException(arg0);
	}
	
}