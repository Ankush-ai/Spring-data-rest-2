package Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.Type;

@Configuration
public class MyRepositoryRestConfigurerAdapter implements RepositoryRestConfigurer {

	@Autowired
	private EntityManager entityManager;

	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(
				entityManager.getMetamodel().getEntities().stream().map(Type::getJavaType).toArray(Class[]::new));
	}

}