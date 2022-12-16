package org.frakin.Application.Service;

import org.springframework.stereotype.Service;

@Service
public class MessageService_1 {
    public String giveMessage(String param) {
        System.out.println("Method gave message.Param :" + param);
        return param;
    }
}
