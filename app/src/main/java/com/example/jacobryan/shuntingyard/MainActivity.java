package com.example.jacobryan.shuntingyard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity
{
    private EditText inputET;
    private TextView outputTV;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.inputET = (EditText)this.findViewById(R.id.inputer);
        this.outputTV = (TextView)this.findViewById(R.id.queueTracker);
    }

    public void processButtonPressed(View v)
    {
        StringTokenizer st = new StringTokenizer(this.inputET.getText().toString(), "+-*/", true);
        Queue output = new Queue();
        Queue operator = new Queue();
        while(st.hasMoreTokens())
        {
            if(st.nextToken() == "+")
            {
                operator.enqueue(st.nextToken());
                operator.getEnd().setPrecedence(2);
                if(operator.getEnd().getPrecedence() <= operator.getFront().getPrecedence())
                {
                    output.enqueue(operator.dequeue().getPayload());
                }
            }
            else if(st.nextToken() == "-")
            {
                operator.enqueue(st.nextToken());
                operator.getEnd().setPrecedence(2);
                if(operator.getEnd().getPrecedence() <= operator.getFront().getPrecedence())
                {
                    output.enqueue(operator.dequeue().getPayload());
                }
            }
            else if(st.nextToken() == "*")
            {
                operator.enqueue(st.nextToken());
                operator.getEnd().setPrecedence(3);
                if(operator.getEnd().getPrecedence() <= operator.getFront().getPrecedence())
                {
                    output.enqueue(operator.dequeue().getPayload());
                }
            }
            else if(st.nextToken() == "/")
            {
                operator.enqueue(st.nextToken());
                operator.getEnd().setPrecedence(3);
                if(operator.getEnd().getPrecedence() <= operator.getFront().getPrecedence())
                {
                    output.enqueue(operator.dequeue().getPayload());
                }
            }
            else
            {
                output.enqueue(st.nextToken());
            }
        }

        while (operator.getCount() > 0)
        {
            output.enqueue(operator.dequeue().getPayload());
        }

        String answer = "";
        while(output.getCount() > 0)
        {
            answer = answer + output.dequeue().getPayload() + ",";
        }
        this.outputTV.setText(answer);
    }
}

