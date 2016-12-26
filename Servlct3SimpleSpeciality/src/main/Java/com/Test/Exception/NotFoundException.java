package com.Test.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by han on 2016/12/15.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "没有这个页面")
public class NotFoundException extends Exception {

}
