package deva.baseconverter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText txtDecimal;
    RadioGroup rg;
    RadioButton rb;
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate (View v) {
        txtDecimal = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        txtView = (TextView) findViewById(R.id.textView);
        int selected_id = rg.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById(selected_id);

        if (rb.getText().toString().equals("Decimal -> Binary"))
        {


            int base = 2;
            if (txtDecimal.getText().toString().trim().length() == 0) {
                txtView.setText("");
                return;
            }
            try {
                Stack<Object> stack = new Stack<Object>();
                int number = Integer.parseInt(txtDecimal.getText().toString());
                while (number > 0) {
                    int remainder = number % base; // find remainder
                       stack.push(remainder);
                        // push remainder in stack
                    number /= base;
                }
                StringBuffer buffer = new StringBuffer();
                while (!stack.isEmpty()) {
                    buffer.append(stack.pop().toString());
                }
                txtView.setText(buffer.toString());
            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }

        else if (rb.getText().toString().equals("Decimal -> Octal"))
        {


            int base = 8;
            if (txtDecimal.getText().toString().trim().length() == 0) {
                txtView.setText("");
                return;
            }
            try {
                Stack<Object> stack = new Stack<Object>();
                int number = Integer.parseInt(txtDecimal.getText().toString());
                while (number > 0) {
                    int remainder = number % base; // find remainder
                    stack.push(remainder);
                        // push remainder in stack
                    number /= base;
                }
                StringBuffer buffer = new StringBuffer();
                while (!stack.isEmpty()) {
                    buffer.append(stack.pop().toString());
                }
                txtView.setText(buffer.toString());
            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }

        else if (rb.getText().toString().equals("Decimal -> Hexadecimal"))
        {


            int base = 16;
            if (txtDecimal.getText().toString().trim().length() == 0) {
                txtView.setText("");
                return;
            }
            try {
                Stack<Object> stack = new Stack<Object>();
                int number = Integer.parseInt(txtDecimal.getText().toString());
                while (number > 0) {
                    int remainder = number % base; // find remainder
                    if (remainder < 10)
                    // for remainder smaller than 10
                    {
                        stack.push(remainder);
                        // push remainder in stack
                    } else {
                        switch (remainder)
                        // for remainder larger than 9 (for hexadecimal values)
                        {
                            case 10:
                                stack.push("A");
                                break;
                            case 11:
                                stack.push("B");
                                break;
                            case 12:
                                stack.push("C");
                                break;
                            case 13:
                                stack.push("D");
                                break;
                            case 14:
                                stack.push("E");
                                break;
                            case 15:
                                stack.push("F");
                                break;
                        }
                    }
                    number /= base;
                }
                StringBuffer buffer = new StringBuffer();
                while (!stack.isEmpty()) {
                    buffer.append(stack.pop().toString());
                }
                txtView.setText(buffer.toString());
            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }
        else if(rb.getText().toString().equals("Binary -> Decimal"))
        {
           try {
               String s = txtDecimal.getText().toString();
               int binary = Integer.parseInt(s,2);
               txtView.setText(binary+"");
           } catch (Exception e) {
               txtView.setText(e.getMessage());
           }
        }
        else if(rb.getText().toString().equals("Octal -> Decimal"))
        {
            try {
                String s = txtDecimal.getText().toString();
                int binary = Integer.parseInt(s,8);
                txtView.setText(binary+"");
            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }

        else if(rb.getText().toString().equals("Hexadecimal -> Decimal"))
        {
            try {
                String s = txtDecimal.getText().toString();
                int binary = Integer.parseInt(s,16);
                txtView.setText(binary+"");

            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }
        else if(rb.getText().toString().equals("Binary -> Hexadecimal"))
        {
            try {
                String s = txtDecimal.getText().toString();
                int binary = Integer.parseInt(s,2);

                int base = 16;
                if (binary == 0) {
                    txtView.setText("0");
                    return;
                }
                    Stack<Object> stack = new Stack<Object>();
                    int number = binary;
                    while (number > 0) {
                        int remainder = number % base; // find remainder
                        if (remainder < 10)
                        // for remainder smaller than 10
                        {
                            stack.push(remainder);
                            // push remainder in stack
                        } else {
                            switch (remainder)
                            // for remainder larger than 9 (for hexadecimal values)
                            {
                                case 10:
                                    stack.push("A");
                                    break;
                                case 11:
                                    stack.push("B");
                                    break;
                                case 12:
                                    stack.push("C");
                                    break;
                                case 13:
                                    stack.push("D");
                                    break;
                                case 14:
                                    stack.push("E");
                                    break;
                                case 15:
                                    stack.push("F");
                                    break;
                            }
                        }
                        number /= base;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (!stack.isEmpty()) {
                        buffer.append(stack.pop().toString());
                    }
                    txtView.setText(buffer.toString());

            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }

        else if(rb.getText().toString().equals("Octal -> Hexadecimal"))
        {
            try {
                String s = txtDecimal.getText().toString();
                int binary = Integer.parseInt(s,8);

                int base = 16;
                if (binary == 0) {
                    txtView.setText("0");
                    return;
                }
                Stack<Object> stack = new Stack<Object>();
                int number = binary;
                while (number > 0) {
                    int remainder = number % base; // find remainder
                    if (remainder < 10)
                    // for remainder smaller than 10
                    {
                        stack.push(remainder);
                        // push remainder in stack
                    } else {
                        switch (remainder)
                        // for remainder larger than 9 (for hexadecimal values)
                        {
                            case 10:
                                stack.push("A");
                                break;
                            case 11:
                                stack.push("B");
                                break;
                            case 12:
                                stack.push("C");
                                break;
                            case 13:
                                stack.push("D");
                                break;
                            case 14:
                                stack.push("E");
                                break;
                            case 15:
                                stack.push("F");
                                break;
                        }
                    }
                    number /= base;
                }
                StringBuffer buffer = new StringBuffer();
                while (!stack.isEmpty()) {
                    buffer.append(stack.pop().toString());
                }
                txtView.setText(buffer.toString());

            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }
        else if(rb.getText().toString().equals("Binary -> Octal"))
        {
            try {
                String s = txtDecimal.getText().toString();
                int binary = Integer.parseInt(s,2);

                int base = 8;
                if (binary == 0) {
                    txtView.setText("0");
                    return;
                }
                Stack<Object> stack = new Stack<Object>();
                int number = binary;
                while (number > 0) {
                    int remainder = number % base; // find remainder

                        stack.push(remainder);
                        // push remainder in stack

                    number /= base;
                }
                StringBuffer buffer = new StringBuffer();
                while (!stack.isEmpty()) {
                    buffer.append(stack.pop().toString());
                }
                txtView.setText(buffer.toString());

            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }
        else if(rb.getText().toString().equals("Hexadecimal -> Binary"))
        {
            try {
                String s = txtDecimal.getText().toString();
                int deci = Integer.parseInt(s,16);
                int base = 2;
                if (deci == 0) {
                    txtView.setText("0");
                    return;
                }

                    Stack<Object> stack = new Stack<Object>();
                    int number = deci;
                    while (number > 0) {
                        int remainder = number % base; // find remainder
                        stack.push(remainder);
                        // push remainder in stack
                        number /= base;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (!stack.isEmpty()) {
                        buffer.append(stack.pop().toString());
                    }
                    txtView.setText(buffer.toString());
            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }
        else if(rb.getText().toString().equals("Hexadecimal -> Octal"))
        {
            try {
                String s = txtDecimal.getText().toString();
                int deci = Integer.parseInt(s,16);
                int base = 8;
                if (deci == 0) {
                    txtView.setText("0");
                    return;
                }

                Stack<Object> stack = new Stack<Object>();
                int number = deci;
                while (number > 0) {
                    int remainder = number % base; // find remainder
                    stack.push(remainder);
                    // push remainder in stack
                    number /= base;
                }
                StringBuffer buffer = new StringBuffer();
                while (!stack.isEmpty()) {
                    buffer.append(stack.pop().toString());
                }
                txtView.setText(buffer.toString());
            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }
        else if(rb.getText().toString().equals("Octal -> Binary"))
        {
            try {
                String s = txtDecimal.getText().toString();
                int deci = Integer.parseInt(s,8);
                int base = 2;
                if (deci == 0) {
                    txtView.setText("0");
                    return;
                }

                Stack<Object> stack = new Stack<Object>();
                int number = deci;
                while (number > 0) {
                    int remainder = number % base; // find remainder
                    stack.push(remainder);
                    // push remainder in stack
                    number /= base;
                }
                StringBuffer buffer = new StringBuffer();
                while (!stack.isEmpty()) {
                    buffer.append(stack.pop().toString());
                }
                txtView.setText(buffer.toString());
            } catch (Exception e) {
                txtView.setText(e.getMessage());
            }
        }

        else
        {
            txtView.setText("Sorry, this module is currently under development.");
        }
    }

    public void about (View v)
    {
        Intent intent = new Intent("deva.baseconverter.about");
        startActivity(intent);
    }

    public void exit(View v)
    {
        AlertDialog.Builder a = new AlertDialog.Builder(MainActivity.this);
        a.setMessage("Are you sure you want to close this app ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog alert = a.create();
        alert.setTitle("Alert!");
        alert.show();
    }
}
