package test;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

/**
 * @description:
 * @author: xuqiang
 * @createDate: 2019-01-09 15:26
 **/
public class TimeServerHandler extends IoHandlerAdapter {
    @Override
    public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception {
        cause.printStackTrace();
    }
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.sessionOpened(session);
//        session.write("0");
    }
    @Override
    public void messageReceived(IoSession session, Object message)
            throws Exception {
        String str = message.toString();
        if (str.trim().equalsIgnoreCase("quit")) {
            session.close();
            return;
        }
//        String hexText = parseMessage(message);

//        System.out.println("报文：" + hexText);
        Date date = new Date();
        session.write(date.toString()+""+str);
        System.out.println("Message written...");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception {
        System.out.println("IDLE " + session.getIdleCount(status));
    }
}
