package wbse;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class AnswerServlet extends HttpServlet {
	//�ϥΪ̼g���ݨ������Ӫ��a��
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        ArrayList<Integer> pollAnswer = (ArrayList<Integer>) request.getAttribute("pollAnswer"); //���o�U�D����
        String userAccount = (String) request.getSession().getAttribute("account"); //���D�^�����H�O��
        Gson gson = new Gson();
        String jsonPollAnswer = gson.toJson(pollAnswer); //�����নjson
        
        //��DB���Ѽ�: filename, userAccount, jsonPollAnswer
        //user_data.insertTable(filename, userAccount, jsonPollAnswer); //�s���Ʈw
	}
}