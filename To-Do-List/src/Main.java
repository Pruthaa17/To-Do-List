import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.WindowAdapter;
        import java.awt.event.WindowEvent;
        import java.util.ArrayList;

public class Main extends Frame {

    ArrayList<String> str = new ArrayList<String>();
    List taskDisplay;

    public Main() {

        setSize(400, 450);
        setTitle("To Do List1");
        setLayout(null);
        setVisible(true);

        Label listHeadL = new Label("To Do List");
        listHeadL.setBounds(150, 50, 130, 30);
        listHeadL.setForeground(Color.darkGray);
        Font listHeadF = new Font("Serif", Font.BOLD, 20);
        listHeadL.setFont(listHeadF);
        add(listHeadL);

        Label listAddL = new Label("Enter your Task :");
        listAddL.setForeground(Color.black);
        listAddL.setBounds(50, 100, 100, 30);
        add(listAddL);

        TextField takeTask = new TextField(20);
        takeTask.setBounds(150, 100, 200, 30);
        add(takeTask);

        Button addButton = new Button("Add Task");
        addButton.setBounds(150, 150, 80, 30);
        add(addButton);

        taskDisplay = new List();
        taskDisplay.setBounds(150, 200, 200, 150);
        add(taskDisplay);

        Button removeB = new Button("Delete");
        removeB.setBounds(150, 370, 120, 30);
        add(removeB);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newTask = takeTask.getText();
                str.add(newTask);
                updateTaskDisplay(); // Update the displayed tasks
                takeTask.setText(""); // Clear the input field
            }
        });

        removeB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = taskDisplay.getSelectedIndex();
                if (index >= 0 && index < str.size()) {
                    str.remove(index);
                    updateTaskDisplay(); // Update the displayed tasks
                }
            }
        });
    }

    void updateTaskDisplay() {
        taskDisplay.removeAll();
        for (String task : str) {
            taskDisplay.add(task);
        }
    }


    public static void main(String[] args) {new Main();}
}

