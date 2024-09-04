package Exceptions;

@FunctionalInterface
public interface ExceptionHandlerFunction<T> {
	T apply() throws Exception;
}