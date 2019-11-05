### INSTRUÇÕES

#### Recupera todos os beneficios salvos.
HttpMethod: GET
```
URL: http://localhost:8080/Beneficio
```

#### Realiza o upload do arquivo e qual categoria ele pertence.
HttpMethod: POST
```
URL: http://localhost:8080/Beneficio/upload?cpf=12345678901&categoria=IDENTIFICACAO
```
Body
```
form-data: 
  key: file
  value: <seuarquivo>
```

#### Recupera o path do arquivo para o cpf informado.
HttpMethod: GET
```
URL: http://localhost:8080/Beneficio/pathFile?cpf=12345678901
```
