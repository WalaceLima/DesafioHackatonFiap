## Servico API

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/servicos</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/servicos' \
  -H 'accept: */*'
```

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/servicos/{id}</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/servicos/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/servicos</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/servicos' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "kit festa",
  "valor": 235
}'
```
<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/servicos/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/servicos/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Café da Manhã",
  "valor": 105
}'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/servicos/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/servicos/1' \
  -H 'accept: */*'
```
---
# Item API

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/item/{id}</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/items/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/item</span>
</div>

```bash
curl -X 'GET' \
  'http://localhost:8080/items' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/item</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/items' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "Coca cola",
  "valor": 6.50
}'
```
<div style="display: flex; align-items: center; background-color: #fff3e0; padding: 5px; border-radius: 5px; border: 2px solid #ff9800;">
  <button style="background-color: #ff9800; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">PUT</button>
  <span style="margin-left: 5px; color: #000000;">/item/{id}</span>
</div>

```bash
curl -X 'PUT' \
  'http://localhost:8080/items/1' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "nome": "cerveja",
  "valor": 5.00
}'
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/item/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/items/1' \
  -H 'accept: */*'
```