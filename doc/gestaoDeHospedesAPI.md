## Cliente API
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/clientes</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/clientes' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/clientes/{id}</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/clientes/cpf/{cpf}</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/clientes/cpf/85908566071' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/clientes</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/clientes' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d ' {
    "paisOrigem": "Rússia",
    "cpf": "25930651094",
    "passaporte": "UK414192",
    "nome": "Leandro Costa",
    "dataNascimento": "1994-12-19",
    "enderecoPaisOrigem": "endereço qualquer na Rússia",
    "telefone": "996983755",
    "email": "leandro@teste.gmail.com"
  }'
```

<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/clientes/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "paisOrigem": "Brasil",
  "cpf": "85908566071",
  "passaporte": "BG665764",
  "nome": "Felipe Santos",
  "dataNascimento": "1991-05-31",
  "enderecoPaisOrigem": "endereço 2 no brasil",
  "telefone": "412341234",
  "email": "leandro@teste.gmail.com"
}'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/clientes/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/clientes/1' \
  -H 'accept: */*'
```