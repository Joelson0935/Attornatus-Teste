# Attornatus-Teste

<h2>Informações básicas do projeto</h2>

<p>versão do spring usada : 2.7.7</p>
<p>banco de dados H2</p>
<p>gerenciador de dependências: maven versão: 3.8.5</p>

<h2>Instruções de Uso da API</h2>

<p>Bem, para testar a API o responsável pode ir no pacote : com.casa.attornatus.configuration.swagger</p>
<p> dentro da classe : SwaggerConfig tem a especificação do caminho para abrir o swagger para testar,</p>
<p> deixe o mouse sobre o nome da classse e clique na palavra swagger para poder abrir no navegador.</p>
<p> No mesmo caminho e do mesmo jeito tem o link para abrir o banco de dados H2 e outro para acessar</p>
<p> este repositório.</p>
<p> para testar o método inserir e também o atualizar, vou deixar o exemplo em JSON aqui.</p>
<p>{
  "dataDeNascimento": "09/01/2023",
  "endereco": {
  "cep": "01310-930"
  },
  "id": 1,
  "nome": "Maria"
}</p>
