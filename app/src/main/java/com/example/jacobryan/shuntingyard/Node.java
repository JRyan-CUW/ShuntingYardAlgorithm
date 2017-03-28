package com.example.jacobryan.shuntingyard;

/**
 * Created by JacobRyan on 3/22/17.
 */

public class Node
{
    private String payload;
    private Node nextNode;
    private int precedence;

    public Node(String payload)
    {
        this.payload = payload;
        this.nextNode = null;
        this.precedence = 0;
    }

    public String getPayload() {
        return payload;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public int getPrecedence() {
        return precedence;
    }

    public void setPrecedence(int precedence) {
        this.precedence = precedence;
    }
}

