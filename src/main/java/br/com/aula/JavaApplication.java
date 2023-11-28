package br.com.aula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@SpringBootApplication(scanBasePackages = "ProdutoRepository")
@SpringBootApplication
@EnableFeignClients

//@SpringBootApplication
public class JavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);

//        System.out.println("Aula 1 JAVA ! ");
//
//        Pessoa pe = new Pessoa();
//        Produto p = new Produto();





        //System.out.println("o produto é : "+p.getDescrição() + " e valor : "+p.getValor());
        //System.out.println(String.format("o produto é %s e o valor é %f",p.getDescrição(),p.getValor()));

       // List<Produto> listaProduto = new ArrayList<>();
        //listaProduto.add(null);

//        for (int x = 0; x <= 9; x++) {
//            p = new Produto();
//            p.setCodigo(Long.valueOf(1 + x));
//            p.setDescricao("teste " + x);
//            p.setValor(29.90 + x);
//            listaProduto.add(p);
//        }
        /*for 0*/
//        for (Produto prod : listaProduto) {
//            if (prod != null) {
//                System.out.println(prod.getDescricao());
//            }
//        }


        /* for 1*/
//        listaProduto.forEach(prod -> {
//            if (prod != null) {
//                System.out.println(prod.getDescricao());
//            }
//        });

        /* transformação de objeto para o for 2 */
   //     List<Optional<Produto>> collect = listaProduto.stream().map(p1 -> Optional.ofNullable(p1)).collect(Collectors.toList());

        /* for 2.1*/
//        collect.forEach(p2 -> {
//            if (p2.isPresent()) {
//                System.out.println(p2.get().getDescricao());
//            }
//        });

        /*for 2.2*/
        // collect.stream().forEach(p2 -> System.out.println(p2.get().getDescricao()));
        /*for 3 */
     //   collect.stream().filter(c -> c.isPresent()).forEach(p2 -> System.out.println(p2.get().getDescricao()));

    }

}
