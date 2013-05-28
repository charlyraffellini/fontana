package utn.tadp.fontana.politica;

public interface CreacionDeDependencia<T extends Object> {

	T getObject();

	CreacionDeDependencia<T> setClass(Class<T> cClass);

}
