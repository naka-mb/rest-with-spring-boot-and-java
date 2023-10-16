package br.com.erudio.integrationtests.testcontainers;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.lifecycle.Startable;
import org.testcontainers.lifecycle.Startables;

import java.util.Map;
import java.util.stream.Stream;

@ContextConfiguration(initializers = AbstractIntegrationTest.Initializer.class)
public class AbstractIntegrationTest {
    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        static MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0.30");

        private static void starContainers() {
            Startables.deepStart(Stream.of(mysql)).join();
        }

        @SuppressWarnings({"unchecked","rawtypes"})
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            starContainers();
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            MapPropertySource testcontainers = new MapPropertySource(
                    "testcontainers",
                    (Map) createConnectionConfiguration());
            environment.getPropertySources().addFirst(testcontainers);
        }
        private Map<String,String> createConnectionConfiguration() {
            return Map.of(
                    "spring.datasource.url",mysql.getJdbcUrl(),
                    "spring.datasource.username",mysql.getUsername(),
                    "spring.datasource.password",mysql.getPassword()
            );
        }
    }


}
