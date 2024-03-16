## Reservas API
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/reservas/{id}</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/reservas/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/reservas/periodo</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/reservas/periodo?dataInicial=2024-03-27&dataFinal=2024-04-05' \
  -H 'accept: */*'
```

<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/reservas/hotel/{id}</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/reservas/hotel/1' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #f0f8ff; padding: 5px; border-radius: 5px; border: 2px solid #007bff;">
  <button style="background-color: #007bff; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">GET</button>
  <span style="margin-left: 5px; color: #000000;">/reservas/cliente/{cpf}</span></div>

```bash
curl -X 'GET' \
  'http://localhost:8080/reservas/cliente/85908566071' \
  -H 'accept: */*'
```
<div style="display: flex; align-items: center; background-color: #e5f5e5; padding: 5px; border-radius: 5px; border: 2px solid #339933;">
  <button style="background-color: #339933; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">POST</button>
  <span style="margin-left: 5px; color: #000000;">/confirmar/{idReserva}</span></div>

```bash
curl -X 'POST' \
  'http://localhost:8080/confirmar/1' \
  -H 'accept: */*' \
  -d ''
```
<div style="display: flex; align-items: center; background-color: #ffe6e6; padding: 5px; border-radius: 5px; border: 2px solid #ff0000;">
  <button style="background-color: #ff0000; color: #ffffff; border: none; padding: 5px 10px; border-radius: 5px;">DELETE</button>
  <span style="margin-left: 5px; color: #000000;">/reservas/{id}</span></div>

```bash
curl -X 'DELETE' \
  'http://localhost:8080/reservas/1' \
  -H 'accept: */*'
```