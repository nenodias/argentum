package br.caelum.argentum.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)//Irá ser usada em tempo de execução
public @interface Coluna {
	int posicao();

	String nome();
	String pattern() default ("%s");
}
