# Lojinha do Airu

O objetive deste projeto é avaliar a qualidade do código dos candidatos a vaga de desenvolvedor no Airu.

A tarefa consiste em clonar este repositório, adicionar algumas features, commitar, e enviar o resultado por e-mail.

## O problema

Este código implementa uma lógica de checkout simplificada de uma loja.

Precisamos adicionar novas features. Ao implementá-las esperamos que o candidato altere o código onde julgar necessário, modificando a estrutura, design das classes e testes.

## Novas features

### Coupon

Uma das formas de diminuir a taxa de abandono de uma compra é oferecer um coupon promocional de desconto. Gostaríamos de distribuir para os clientes coupons com as seguintes características:

- Possui um valor de desconto;
- Só pode ser aplicado no caso de o valor da compra ultrapassar um valor mínimo;
- Ao usá-lo em uma compra, imprimir mensagem "Desconto: valor"

### Novos tipos de produto

Recebemos alguns tipos de produto que possuem uma lógica de cálculo de preço e frete diferentes. Trata-se de produtos perecíveis que precisam ser resfriados no transporte. O custo do frete deve ser 10 vezes o padrão.