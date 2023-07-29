# **Santander Dev Week 2023**

> Projeto baseado no projeto criado na live Santander Dev Week 2023

Nesse projeto fiz algumas alterações do projeto original. Entre elas estão: 

- Alteração da injeção de dependência Dagger Hilt para Koin
- Criação das libraries: para network, extensions e testing
- Acréscimo de classes na arquitetura MVVM
- Mudança na chamada de network. Ela é chamada a partir da library network (Eu construí uma estrutura própria para chamadas de network do projeto)
- Alteração do projeto utilizando Groove para Kotlin DSL. Nesse caso, o gerenciamento das dependências do projeto é feita utilizando o buildSrc.
- Acréscimo de testes unitários nas classes de repository, usecase e ViewModel 
