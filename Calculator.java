
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener
{
    JFrame frame;
    JTextField textField;
    // This is an Array Button Show Number 0 to  10.
    JButton[] numberButton = new JButton[10];
    /**
    *For Calculator Functionality like Add, Subtraction , Equal , Clear Delete Button etc...
    */
    JButton[] functionButtons = new JButton[8];
    JButton AddButton, SubButton, MulButton, DivButton;
    JButton DecimalButton, EqualButton,DeleteButton, ClearButton;
    JPanel panel;
    // Set Font And Color
    Font myfont = new Font("Ink Free",Font.BOLD,30);
    double num1=0, num2=0, result=0;
    char operator;
    Calculator()
    {
        frame  =new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myfont);
        textField.setSelectedTextColor(Color.BLACK);
        textField.setEnabled(false);

        //Set Button Name for Show on Panel.
        AddButton = new JButton("+");
        SubButton = new JButton("-");
        MulButton =  new JButton("*");
        DivButton = new JButton("/");
        DecimalButton = new JButton(".");
        EqualButton =new JButton("=");
        DeleteButton =new JButton("Cancel");
        ClearButton =new JButton("Clear");

        functionButtons[0] = AddButton;
        functionButtons[1] = SubButton;
        functionButtons[2] = MulButton;
        functionButtons[3] = DivButton;
        functionButtons[4] = DecimalButton;
        functionButtons[5] = EqualButton;
        functionButtons[6] = DeleteButton;
        functionButtons[7] = ClearButton;

        // This loop for Changing Operation.
        for(int i=0; i<8; i++)
        {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myfont);
            functionButtons[i].setFocusable(false);
        }

        // This loop for C
        for(int i=0; i<10; i++)
        {
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myfont);
            numberButton[i].setFocusable(false);
        }
        DeleteButton.setBounds(50,430,145,50);
        ClearButton.setBounds(205,430,145,50);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        // Set Rows 4 and Columns 4
        //How much space between the Button, Horizontal and Vertical 10/10.
        panel.setLayout(new GridLayout(4,4,10,10));

        //This is 1st Row
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(AddButton);

        //This is 2nd Row
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(SubButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(MulButton);
        panel.add(DecimalButton);
        panel.add(numberButton[0]);
        panel.add(EqualButton);
        panel.add(DivButton);


        frame.add(panel);
        frame.add(DeleteButton);
        frame.add(ClearButton);
        frame.add(textField);
        frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        Calculator calculator =new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (int i=0; i<10; i++)
        {
            if(e.getSource() ==  numberButton[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource() == DecimalButton)
        {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == AddButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == SubButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == MulButton)
        {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == DivButton)
        {
	            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == EqualButton)
        {
            num2 = Double.parseDouble(textField.getText());
            switch (operator)
            {
                case '+' :
                    result = num1 + num2;
                    break;
                case '-' :
                    result = num1 - num2;
                    break;
                case '*' :
                    result = num1 * num2;
                    break;
                case '/' :
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource() == ClearButton)
        {
             textField.setText("");
        }
        if(e.getSource() == DeleteButton)
        {
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; i++)
            {
				textField.setText(textField.getText()+string.charAt(i));
            }
        }
    }
}
