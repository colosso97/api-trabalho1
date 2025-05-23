Atividade em Grupo

Pontuação: 10 Pontos
Criar um novo projeto maven usando o Spring com as seguintes dependências:
• Spring Web
• Spring Data JPA
• Validation
• Postgres
• H2
• Dev Tools
application.properties
Configurar o arquivo de propriedades application.properties. Adicionar dois perfis um
para uso do banco de dados postgres (production) e outro para o banco de dados h2
(developer) salvando o banco em um arquivo. O arquivo application.properties deverá
ser configurado para iniciar no profile de developer.
Classes
Criar as classes(entidades) abaixo com os seguintes atributos:
Vendedor
• codigoVendedor
• nome
• email
• salario
VendedorAutonomo herdando de Vendedor com os seguinte atributo:
• comissão
VendedorEmpresa
• numeroCarteiraTrabalho
• dataAdmissao
Obs: Analisar as opções de herança na classe Vendedor escolhendo a melhor estratégia
para mapeamento da herança para a criação de tabelas no banco de dados.
LancamentoVendas
• codigoVenda
• dataVenda
• valorVenda
• vendedor
Fazer o mapeamento relacional (ORM) para as classes acima.
Relacionamento: Um vendedor possui um ou vários lançamento de vendas.

Popular tabela
Popular a tabela de vendedor com 1000 registros utilizando o site para geração de
dados https://www.mockaroo.com

Validação
Criar uma validação para os campos nome, email e salario.
• Os salários não poderão ser inferiores ao salário mínimo.
• Nomes não poderão ser nulos ou vazios.
• Utilizar a anotação para verificação do email.

Exception
• Criar a classe que intercepta os erros de exceção do Spring.
• Criar um método para tratar os erros de validação.
• Criar um método para tratar os recursos não encontrados NotFound.
DTO
Cria uma classe com o nome LancamentoVendasResponseDTO com os seguintes
atributos:
• dataVenda
• valorVenda
• nomeVendedor

Service, Controller e Repository somente para a classe LancamentoVendas
• Criar a interface LancamentoRepository
• Criar a classe LancamentoService com os seguintes métodos:
listarPorId
inserirLancamento
• Criar a classe LancamentoController com os seguintes métodos:
listarPorId
inserirLancamento

Testar no Postman
