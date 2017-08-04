# cep-java
## - consulta de CEP viacep
###### - https://viacep.com.br/

```
CepConfiguration cepConfiguration = new CepConfiguration();
Map<String, Object> map = new CepService(cepConfiguration).get("30180-001");
System.out.println(map);
-
```
