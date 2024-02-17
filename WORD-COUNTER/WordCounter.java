 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter extends JFrame {

    private JTextArea txtArea;
    private JLabel counterLabel;
    private JLabel ans;

    public WordCounter() {
        setVisible(true);
        setSize(350, 250);
        setTitle("Word Counter Page");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        userInterface();
    }

    private void userInterface() {
        ans = new JLabel("Enter your text below: ");
        txtArea = new JTextArea();
        counterLabel = new JLabel(" ");

        JButton countBttn = new JButton("Count Words");
        JButton openFileBttn = new JButton("Open File");

        JScrollPane scrollPane = new JScrollPane(txtArea);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(countBttn);
        buttonPanel.add(openFileBttn);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(counterLabel, BorderLayout.SOUTH);
        getContentPane().add(ans, BorderLayout.NORTH);

        countBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ans.setText("Enter your text below: ");
                String txt = txtArea.getText();
                int wordCount;
                if (txt.length() == 0)
                    wordCount = 0;
                else
                    wordCount = countWords(txt);
                counterLabel.setText("Number of words in text: " + wordCount);
            }
        });

        openFileBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                ans.setText("Enter your text below: ");
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                        String fileContent = readFileContent(selectedFile);
                        txtArea.setText(fileContent);
                    } catch (IOException e) {
                        counterLabel.setText("Error reading file: " + e.getMessage());
                    }
                }
            }
        });
    }

    private int countWords(String str) {
        String[] words = str.trim().split("\\s+");
        return words.length;
    }

    private String readFileContent(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public static void main(String[] args) {
        new WordCounter();
    }
}