package Dop_ReviewBotTask;

import java.time.LocalDate;

public class Report {

    private Long id;

    private String studentUserName;

    private Integer hours;

    private LocalDate date;

    private String title;

    public Report(long id, String studentUserName, Integer hours, LocalDate date, String title) {
        this.id = id;
        this.studentUserName = studentUserName;
        this.hours = hours;
        this.date = date;
        this.title = title;
    }

    public String getStudentUserName() {
        return studentUserName;
    }

    public Integer getHours() {
        return hours;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }
}
