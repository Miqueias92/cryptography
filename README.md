# cryptography
POC para análise de algoritmos de criptografia

## refs:

https://www.evaltec.com.br/criptografia-de-dados-e-gerenciamento-de-chaves/

https://cryptoid.com.br/valid/tipos-de-criptografia-conheca-os-10-mais-usados-e-como-funciona-cada-um/

Criptográfia

#### Simetrica (AES) - Os primeiros utilizam uma única chave para cifrar e decifrar os dados

#### Assimetrica (RSA)  - enquanto os segundos adotam par de chaves, sendo uma para cifrar e a outra para decifrar.Um ponto interessante deste tipo de algoritmo é que, após cifrar com a chave pública, apenas a privada pode decifrar.


Tipos que vou usar no estudo:

## AES 
-  algoritmo padrão do governo dos Estados Unidos e de várias outras organizações. 
Ele é confiável e excepcionalmente eficiente na sua forma em 128 bits, 
mas também é possível usar chaves e 192 e 256 bits para informações que precisam de proteção maior.

O AES tem como principais características segurança, desempenho, facilidade de implementação, flexibilidade e exige pouca memória,

## Camellia 
- Desenvolvido em 2000, Camellia é uma criptografia que decifra blocos de informações. 
Trata-se de uma tecnologia com níveis de segurança bastante semelhantes ao AES, 
já que pode ser processada em 128, 192 e 256 bits.

## RSA (Assimétrica)
- Rivest-Shamir-Adleman (RSA) foi um dos pioneiros em relação à criptografia de chave pública, 
seu nome é composto pelos sobrenomes de seus criadores, que também são fundadores da companhia RSA Data Security. 

## Blowfish (Simétrica) 
 - O Blowfish é conhecido por sua velocidade de encriptação 
e efetividade em geral. Trata-se de uma tecnologia bastante segura, 
pois há estudiosos no assunto que afirmam que o código não pode ser quebrado.

## Twofish (Simétrica) 
  - O Twofish é uma variação do Blowfish e também consiste na cifração de blocos simétricos.
 A diferença é que ele é formado por blocos de 128 bits e chaves de até 256 bits.

A tecnologia é considerada uma das mais rápidas de seu tipo e é ideal para prover segurança de softwares e hardwares. Seu código-fonte também é gratuito, podendo ser manipulado e utilizado por qualquer programador.

### Algoritmos de chave simétrica são mais rápidos do que assimétricas

Entre os sistemas criptográficos simétricos temos: IDEA, TwoFish, BlowFish, Serpent, DES, AES, RC5, RC6.

</br>

### O estudo apresentou o seguinte resultado:

#### ANALISE DE DESEMPENHO EM MILISEGUNDOS PARA: 5000

Tempo de criptografia do AES: 295 </br>
Tempo de descriptografia do AES: 103

Tempo de criptografia do DES: 136 </br>
Tempo de descriptografia do DES: 123

Tempo de criptografia do RCA: 66 </br>
Tempo de descriptografia do RCA: 47

Tempo de criptografia do Camellia: 138 </br>
Tempo de descriptografia do Camellia: 67

