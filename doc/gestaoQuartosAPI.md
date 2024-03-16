## Hotel API

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{id}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/1' \
  -H 'accept: */*
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{id}/servicos</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/2/servicos' \
  -H 'accept: */*'
```


<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{id}/itens</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/4/itens' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/nome/{nome}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/nome/HOTEL%20FIAP%202' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/logradouro/{logradouro}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/logradouro/rua%20teste%20logradouro%202' \
  -H 'accept: */*'
```

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/cep/{cep}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/hotel/cep/54123945' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/hotel</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/hotel' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Hotel 5",
  "endereco": {
    "logradouro": "endereco hotel 5",
    "cep": "25641730",
    "cidade": "rio de janeiro",
    "estado": "rio de janeiro"
  }
}'
```

<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{idHotel}/item/{idItem}</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/hotel/3/item/2' \
  -H 'accept: */*' \
  -d ''
```

<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{idHotel}/adicionarServico/{idServico}</span></div>


```bash
curl -X 'POST' \
  'http://localhost:8080/hotel/2/adicionarservico/3' \
  -H 'accept: */*' \
  -d ''

  ```


<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{hotelId}/predio</span></div>

  ```bash
curl -X 'POST' \
  'http://localhost:8080/hotel/3/predio' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Predio novo"
}'
  ```
<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/hotel/{id}?id=1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Novo nome de Hotel",
  "endereco": {    
    "logradouro": "rua alterada",
    "cep": "cep alterado",
    "cidade": "cidade alterada",
    "estado": "estado alterado"
  }
}'
```

<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/hotel/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{idHotel}/item/{idItem}</span></div>


```bash
curl -X 'DELETE' \
  'http://localhost:8080/hotel/3/item/2' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{idHotel}/predio/{idPredio}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/hotel/1/predio/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/hotel/{idHotel}/servico/{idServico}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/hotel/1/servico/1' \
  -H 'accept: */*'
```
---

## Predio API

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/predio</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/predio' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/predio/{id}</span>
</div>

```bash
curl -X 'GET' 'http://localhost:8080/predio/1' -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/predio/nome/{nome}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/predio/nome/PREDIO%204%20HOTEL%204' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/predio/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/predio/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "FIAP HOTEL 1"
}'
```
---

## Quarto API

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/quartos</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/quartos' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/{id}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/quartos/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/tipo/{idTipoQuarto}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/quartos/tipo/1' \
  -H 'accept: */*'
```
  <div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/quantidadeHospedes/{quantidadeHospedes}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/quartos/quantidadeHospedes/2' \
  -H 'accept: */*'
```

<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/quartos</span></div>


```bash
curl -X 'POST' \
  'http://localhost:8080/quartos' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "idPredio": 1,
  "idTipoQuarto": 1,
  "status": "DISPONIVEL",
  "valorDiaria": 1
}'
  ```

<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/recomendarQuartos</span></div>


```bash
curl -X 'POST' \
  'http://localhost:8080/quarto/recomendarQuartos' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "dataInicio": "2024-03-15",
  "dataFim": "2024-03-20",
  "quantidadePessoas": 5,
  "numeroSugestoes": 3
}'
  ```

<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/quartos/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "idPredio": 1,
  "idTipoQuarto": 1,
  "status": "DISPONIVEL",
  "valorDiaria": 214
}'
```

<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/indisponibilizar/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/quartos/indisponibilizar/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/quartos/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/quartos/1' \
  -H 'accept: */*'
```