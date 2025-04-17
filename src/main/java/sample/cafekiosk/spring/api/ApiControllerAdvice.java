package sample.cafekiosk.spring.api;


import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST) // 예외가 발생했을때 어떤 코드로 줄 지 정하는 것
    @ExceptionHandler(BindException.class) // @Valid로 걸리는 exception
    public ApiResponse<Object> bindException(BindException e) {
        ObjectError data = e.getBindingResult().getAllErrors().get(0);
        return ApiResponse.of(
                HttpStatus.BAD_REQUEST,
                data.getDefaultMessage(),
                null); // 어노테이션에 정의 가능
    }

}
