package com.technical_challenge.Internal.task.management.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.customizers.OpenApiCustomizer;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SwaggerConfig implements WebMvcConfigurer {

        @Bean
        OpenAPI springTaskOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Task Management")
                            .description("API for task management")
                            .version("v0.0.1")
                            .license(new License()
                                    .name("Task Management"))
                            .contact(new Contact()
                                    .name("Task Management")
                                    .url("https://github.com/Anacss24/Technical-challenge-iPaaS-Backend-Java")
                                    .email("anaclaudiasantanadev@gmail.com")))
                    .externalDocs(new ExternalDocumentation()
                            .description("Github")
                            .url("https://github.com/Anacss24/Technical-challenge-iPaaS-Backend-Java"));
        }


    public OpenApiCustomizer removeMethodsCustomizer() { // Nome do método atualizado para clareza
        return openApi -> {
            // Itera sobre todos os caminhos (paths) da API
            openApi.getPaths().values().forEach(pathItem -> {
                // Remove os métodos que você não quer exibir na documentação
                pathItem.setHead(null);
                pathItem.setOptions(null);
                pathItem.setDelete(null);
                pathItem.setPut(null);// <-- LINHA ADICIONADA AQUI
            });
        };
    }
        @Bean
        OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {

            return openApi -> {
                openApi.getPaths().values().forEach(pathItem -> {

                    pathItem.setHead(null);
                    pathItem.setOptions(null);
                    pathItem.setDelete(null);
                    pathItem.setPut(null);

                    pathItem.readOperations().forEach(operation -> {

                        ApiResponses apiResponses = operation.getResponses();

                        apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                        apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
                        apiResponses.addApiResponse("204", createApiResponse("Objeto Excluído!"));
                        apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
                        apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado!"));
                        apiResponses.addApiResponse("403", createApiResponse("Acesso Proibido!"));
                        apiResponses.addApiResponse("404", createApiResponse("Objeto Não Encontrado!"));
                        apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!"));

                    });
                });
            };
        }

        private ApiResponse createApiResponse(String message) {

            return new ApiResponse().description(message);

        }

        public void addCorsMappings(CorsRegistry registry) {
            // Configura CORS para todas as rotas
            registry.addMapping("/**") // Aplica a todas as rotas
                    .allowedOrigins("http://localhost:8080")
                    .allowedMethods("GET", "POST", "PATCH") // Métodos permitidos
                    .allowedHeaders("Authorization", "Content-Type"); // Permite os cabeçalhos Authorization e Content-Type

        }

    }
