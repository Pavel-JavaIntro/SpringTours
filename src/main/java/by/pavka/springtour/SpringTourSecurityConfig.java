package by.pavka.springtour;

import org.springframework.orm.jpa.EntityManagerFactoryInfo;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@EnableWebSecurity
public class SpringTourSecurityConfig
        extends WebSecurityConfigurerAdapter
{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        EntityManagerFactoryInfo info = (EntityManagerFactoryInfo) entityManager.getEntityManagerFactory();
        DataSource dataSource = info.getDataSource();
        auth.jdbcAuthentication().dataSource(dataSource);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/register").permitAll()
                .antMatchers("/springtours").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
                .antMatchers("/springtours/book").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
                .antMatchers("/users/account").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
                .antMatchers("/users").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/authorities").hasRole("ADMIN")
//                .antMatchers("/SpringTour/index.html").permitAll()
//                .antMatchers("/SpringTour/users").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
//                .antMatchers("/libraryUsers").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
//                .antMatchers("/users").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
//                .antMatchers("/tours").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
//                .antMatchers("/tourTypes").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
//                .antMatchers("/authorities").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
//                .antMatchers("/tourTypes").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
//                .antMatchers("/authorities/**").hasAnyRole("ADMIN", "MANAGER", "TOURIST")
//                .antMatchers("/tours/**").hasRole("ADMIN")
//                .antMatchers("/libraryUsers/**").hasRole("ADMIN")
                .and().formLogin().permitAll();
    }
}
