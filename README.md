<h1 align="center">API Rest para uma base dados de filmes.</h1>

<p align="center">Desenvolvi essa API rest para uma base de dados de filmes. Nessa API é possível cadastrar e atualizar dados de filmes, localizar filmes atráves do ID, Titulo ou Genêro e excluir filmes da base.</p>

### Request: POST (Create)

Para cadastrar um filme:

   	Acessar a URL: http://localhost:8080/movies
    
   	Dados a serem inseridos:
    
   	{
		"title": "Jumanji (1995)",
		"genres": "Adventure|Children|Fantasy"
   	}
    
OBS: O ID do filme é inserido de forma automática e incrementado a cada cadastro de filme.
    
### Response:
    
   	Status: 201 Created
    
  	{
      		"movieId": 2,
		"title": "Jumanji (1995)",
		"genres": "Adventure|Children|Fantasy"
	}
    
### Request: GET (Read)

Para buscar informações de um filme:

   	Acessar a URL: http://localhost:8080/movies

### Response:
    
   	Status: 200 OK
    
   	{
      		"movieId": 1,
      		"title": "Toy Story (1995)",
      		"genres": "Adventure|Animation|Children|Comedy|Fantasy"
   	},
    
   	{
      		"movieId": 2,
      		"title": "Jumanji (1995)",
      		"genres": "Adventure|Children|Fantasy"
   	}

## Tipos de busca(GET) e endpoints:
    
   É possível realizar a busca de filme por ID, Título e Gênero. Segue endpoints abaixo:
    
# getByMovieId: Buscar filmes pelo ID
   	http://localhost:8080/movies/{movieId}
    
# getByTitle: Buscar filmes pelo Título
  	http://localhost:8080/movies/title/{title}
 
# getByGenres: Buscar flmes pelo Gênero
   	http://localhost:8080/movies/genres/{genres}

OBS: Não é necessário na busca por título e gênero, inserir palavras inteiras, basta digitar letras que fazem referência a busca (exemlo de busca por título: Adv (Adventure)), pois os métodos irá retornar os filmes em tenham essa referência e irá inclusive ignorar caso não esteja com letra maiúscula.

### Request: PUT (update)

   	Acessar a URL: http://localhost:8080/movies
   
   	Digitar a atualização:
   
  	{
     		"movieId": 2,
     		"title": "Jumanji (1995)",
     		"genres": "Adventure|Children|Fantasy|Science Fiction"
  	}
   
### Response:
   
  	{
     		"movieId": 2,
     		"title": "Jumanji (1995)",
     		"genres": "Adventure|Children|Fantasy|Science Fiction"
  	}

### Request: DELETE (Delete)
   
  	Acessar a URL: http://localhost:8080/movies/{movieId}
   
OBS: A exclusão de filme, esta configurada para ser feita através do ID do filme.

### Response:

  	Status: 200 OK
   
   
   
    
