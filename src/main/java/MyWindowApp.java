import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class MyWindowApp extends JFrame {
    JTextField smallField, smallField2;
    private String[] data;
    private   JButton button;
    private int b = 0;
    private int abc = 0;
    private  int c = 0;
    private String[] nameOfPeople1 = {"             ","                     ","              ","                      ","                  "};
    private  String[] nameOfPeople2 = {"             ","                     ","              ","                      ","                  "};
    private  String[] nameOfPeople3 = {"             ","                     ","              ","                      ","                  "};
    private  JList<String> list2;
    private JList<String>  textArea2;
    private JLabel textArea;
    private JLabel textArea3;
    private JLabel textArea4;
    private JList<String> list1;
    private JList<String> list3;
    private JList<String> list4;
    private JPanel contents;
    private StringBuilder stringBuilder;
    private JOptionPane frame;
    private  cash cash = new cash();
    private String[] allmoney = {"Баланс-" + cash.getAllcash()};
    private DefaultListModel model1 = new DefaultListModel();
    private DefaultListModel model2 = new DefaultListModel();
    private DefaultListModel model3 = new DefaultListModel();
    private DefaultListModel model4 = new DefaultListModel();
    private filmPull filmPull;
    private filmPull filmPull2;
    private filmPull filmPull3;
    public MyWindowApp() {
        super("Cinema Operator");
        setBounds(400, 400, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        filmPull = new filmPull("1.Это не баг,а фича");
        filmPull2 = new filmPull("2.Почини чайник,тыж програмист 2");
        filmPull3 = new filmPull("3.Ты получаешь такую зарплату за то что просто клацаешь по клавиатуре???? 3");
        data = new String[]{filmPull.getName(),filmPull2.getName(),filmPull3.getName()};
        button = new JButton("Запись");
        smallField = new JTextField(15);
        smallField.setToolTipText("Введите имя клиента");
        smallField2 = new JTextField(15);
        smallField2.setToolTipText("Номер фильма");
        textArea = new JLabel("Програма для записи в кинотеатр. "+ "\nРазработчик В.О Бельський.\n");
        textArea3 = new JLabel("Список записаных людей.  " +  "\nФильм начинаеться после того как небрёться 10 человек\n" + "                                                                                                           ");
        list1 = new JList<String>(data);
        textArea2 = new JList<String>(allmoney);
        list2 = new JList<String>(nameOfPeople1);
        list3 = new JList<String>(nameOfPeople2);
        list4 = new JList<String>(nameOfPeople3);
        textArea4 = new JLabel(String.valueOf("Баланс" + stringBuilder));
        stringBuilder = new StringBuilder(cash.getAllcash());
        contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
        list2.setFixedCellWidth(180);
        list2.setFixedCellHeight(20);
        list3.setFixedCellWidth(180);
        list3.setFixedCellHeight(20);
        list4.setFixedCellWidth(180);
        list4.setFixedCellHeight(20);
        contents.add(smallField);
        contents.add(smallField2);
        contents.add(button);
        contents.add(textArea4);
        contents.add(textArea);
        contents.add(new JScrollPane(list1));
        contents.add(textArea3);
        contents.add(new JScrollPane(list2));
        contents.add(new JScrollPane(list3));
        contents.add(new JScrollPane(list4));
        setContentPane(contents);
        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                int l = Integer.parseInt(smallField2.getText());
                stringBuilder.delete(0,100);
                stringBuilder.append(cash.getAllcash());
                textArea4.setText("Баланас-" + stringBuilder);
                if (l == 1){
                    model1.addElement(smallField.getText() + " id - " + smallField2.getText());
                    list2.setModel(model1);
                    cash.plusCache(200);


                }
                if (l == 2){
                    model2.addElement(smallField.getText() + " id - " + smallField2.getText());
                    list3.setModel(model2);
                    cash.plusCache(200);
                }
                if (l == 3){
                    model3.addElement(smallField.getText() + " id - " + smallField2.getText());
                    list4.setModel(model3);
                    cash.plusCache(200);
                }
                if(model1.getSize() == 11){
                    model1.clear();
                    JOptionPane.showMessageDialog(frame, "Зрители успешно посмотрели фильм - " + data[0] + "\n" + " Все получили и вернули очки " + "\n" + " Кинотеатр заработал " + 10*200);

                }
                if(model2.getSize() == 10){
                    model2.clear();
                    JOptionPane.showMessageDialog(frame, "Зрители успешно посмотрели фильм - " + data[1] + "\n" + " Все получили и вернули очки " + "\n" + " Кинотеатр заработал " + 10*200);
                }
                if(model3.getSize() == 10){
                    model3.clear();
                    JOptionPane.showMessageDialog(frame, "Зрители успешно посмотрели фильм - " + data[2] + "\n" + " Все получили и вернули очки " + "\n" + " Кинотеатр заработал " + 10*200);
                }

            }
        });
    }










}

