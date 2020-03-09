
start:- % Initialization procedures
    reconsult('user_input.pl'),nl,
    reconsult('major_description.pl'),nl,
    reconsult('kb.pl'),nl,
    reconsult('calculate_threshold.pl'),nl,
    reconsult('tree.pl'),nl,
    start_logo,
    clear,
    menu.


save:- % Saves new temporary info for use by inference engine

    nl,nl,write('Saving data . . .'),nl,
    tell('user_input.pl'),
    listing(second_first_term_grade),
    listing(second_second_term_grade),
    listing(third_cs_first_term_grade),
    listing(third_cs_second_term_grade),
    listing(third_ct_first_term_grade),
    listing(interest),
    told,
    write('Saved Successfully'),nl,nl.

clear:- % Clears all temporary data from temporary data file
    abolish(second_first_term_grade/2),
    abolish(second_second_term_grade/2),
    abolish(third_cs_first_term_grade/2),
    abolish(thrid_cs_second_term_grade/2),
    abolish(thrid_ct_second_term_grade/2),
    abolish(interest/2),
    tell('user_input.pl'),
    told.


prompt_second_first_grade(Subject, Title):-
    write(Title),
    write(": "),
    read(Grade),
    (Grade = 0 -> end_logo ; assert(second_first_term_grade(Subject, Grade))).
prompt_second_second_grade(Subject, Title):-
    write(Title),
    write(": "),
    read(Grade),
    (Grade = 0 -> end_logo ; assert(second_second_term_grade(Subject, Grade))).
prompt_third_cs_first_grade(Subject, Title):-
    write(Title),
    write(": "),
    read(Grade),
    (Grade = 0 -> end_logo ; assert(third_cs_first_term_grade(Subject, Grade))).
prompt_thrid_cs_second_grade(Subject, Title):-
    write(Title),
    write(": "),
    read(Grade),
    (Grade = 0 -> end_logo ; assert(third_cs_second_term_grade(Subject, Grade))).
prompt_third_ct_first_grade(Subject, Title):-
    write(Title),
    write(": "),
    read(Grade),
    (Grade = 0 -> end_logo ; assert(third_ct_first_term_grade(Subject, Grade))).

prompt_interest(Interest, Title):-
    write("What is your level of interest in "),
    write(Title),
    write(" "),
    read(Interest_Level),
    assert(interest(Interest, Interest_Level)).

interest_instructions:-
    nl,
    write("Great, now you will answer a few more questions concerning yourself."),nl,
    write("Kindly respond with numbers from 0 to 4:"),nl,nl,
    write("0 - None"),nl,
    write("1 - Low"),nl,
    write("2 - Medium"),nl,
    write("3 - High"),nl,
    write("4 - Very high"),nl,nl.


grade_instructions:-   /*** Gives instructions for entering grades ***/
    write("For example, "), nl,
    write("A+, A -> 4.0, A- -> 3.67 "),nl,
    write("B+ -> 3.33, B -> 3.0, B- -> 2.67 "),nl,
    write("C+ -> 2.33, C -> 2.0"),nl,
    write("If you did not pass, enter 0 to quit"),nl,nl.


menu:-
    /* Clear existing facts before asking for new ones */
    ask_second_grades,
    write("Are you a  cs or ct student?"),nl,
    read(X),nl,
    string_lower(X, Student_Type),
    write('-------------------------------------------------------------------------------'),nl,nl,

    ask_third_grades(Student_Type),
    ask_interest_level(Student_Type),
    save,
    show_majors.

ask_second_grades :-

    write("Enter the grade points you got in First Term of 2nd Year"),nl,
    grade_instructions,
    prompt_second_first_grade(osf, "Operating Systems Fundamentals"),
    prompt_second_first_grade(cal2, "Calculus II"),
    prompt_second_first_grade(sma, "Software Modelling and Analysis"),
    prompt_second_first_grade(b_fis, "Introduction To Business and Fundamental of Information Systems"),
    prompt_second_first_grade(bec, "Basic Engineering Circuit"),
    prompt_second_first_grade(elp3, "English Language Proficiency III"),nl,
    write('-------------------------------------------------------------------------------'),nl,

    sleep(0.5),nl,
    write("Enter the grade points you got in Second Term of 2nd Year"),nl,

    grade_instructions,
    prompt_second_second_grade(dsa, "Data Structure and Alogrithm"),
    prompt_second_second_grade(ds2, "Discrete Structure II"),
    prompt_second_second_grade(hci_is, "Human Computer Interaction and Information Security"),
    prompt_second_second_grade(dbms, "Database Management System"),
    prompt_second_second_grade(nf, "Networking Fundamentals"),
    prompt_second_second_grade(elp4, "English Language Proficiency IV "),nl,nl,
    write('-------------------------------------------------------------------------------'),nl,nl,
    sleep(0.5).
ask_third_grades(Student_Type) :-
    write("Enter the grade points you got in First Term of 3rd Year"),nl,
    prompt_third_cs_first_grade(ai, "Aritificial Intelligence"),
    prompt_third_cs_first_grade(em, "Engineering Mathematics "),
    prompt_third_cs_first_grade(an, "Advanced Networking"),
    prompt_third_cs_first_grade(ca, "Computer Architecture"),
    prompt_third_cs_first_grade(sre, "Software Requirement Engineering"),
    (Student_Type = "cs",
        prompt_third_cs_first_grade(awt, "Advanced Web Technology"),nl,
        write('-------------------------------------------------------------------------------'),nl,nl,
        write("Enter the grade points you got in Second Term of 3rd Year"),nl,
        prompt_thrid_cs_second_grade(plp, "Programming Languages Principle"),
        prompt_thrid_cs_second_grade(co, "Computer Organisation"),
        prompt_thrid_cs_second_grade(la_ns, "Linear Algebra, Numeric and Statistics"),
        prompt_thrid_cs_second_grade(mp_ee, "Management Principles and Engineering Economics"),
        prompt_thrid_cs_second_grade(nd_e, "Network Design and Engineering"),nl,nl
    );
    (Student_Type = "ct",
        prompt_third_ct_first_grade(ec_s, "Engineering Circuits and Signals"),nl,nl,
        write("Enter the grade points you got in Second Term of 3rd Year"),nl,
        prompt_thrid_cs_second_grade(plp, "Programming Languages Principle"),
        prompt_thrid_cs_second_grade(co, "Computer Organisation"),
        prompt_thrid_cs_second_grade(la_ns, "Linear Algebra, Numeric and Statistics"),
        prompt_thrid_cs_second_grade(mp_ee, "Management Principles and Engineering Economics"),
        prompt_thrid_cs_second_grade(nd_e, "Network Design and Engineering"),nl,nl,
        write('-------------------------------------------------------------------------------'),nl
    ).

ask_interest_level(Student_Type) :-
    interest_instructions,
    (Student_Type = "cs",
        prompt_interest(business, "Business"),
        prompt_interest(analyzing_data, "Marketing Principles"),
        prompt_interest(programming, "Machine Learning with Data Visualization"),
        prompt_interest(ood, "Software Construction and Evaluation"),
        prompt_interest(expert_system, "Intelligent System"),
        prompt_interest(algorithms, "Robotic System"),
        prompt_interest(linux_os, "Blockchain Technology and the Internet of Things"),
        prompt_interest(parallel_computing, "Parallel Computing"),
        write('-------------------------------------------------------------------------------'),nl
    );
    (Student_Type = "ct",
        prompt_interest(telecom_network, "Network Operating Systems"),
        prompt_interest(data_trans, "Broadband Communication and Mobile Networking"),
        prompt_interest(sensors_electronics, "Sensors and Electronics"),
        prompt_interest(digital_signal, "Computer Vision and Digital Image Processing"),
        write('-------------------------------------------------------------------------------'),nl
    ).


help :- write("To start the expert system please type 'start.' and press Enter key").
start_logo :-
    nl,
    sleep(0.5),
    write('-------------------------------------------------------------------------------'),nl,
    sleep(0.5),
    write('*******************************************************************************'),nl,
    sleep(0.5),
    write("###################||| MAJOR ADVISOR EXPERT SYSTEM |||#########################"),nl,
    sleep(0.5),
    write('*******************************************************************************'),nl,
    sleep(0.5),
    write('-------------------------------------------------------------------------------'),nl,nl,nl,
    sleep(0.5).



end_logo :-

    write('\e[H\e[2J'),
    sleep(0.4),nl,nl,nl,
    write('-------------------------------------------------------------------------------'),nl,
    write('*******************************************************************************'),nl,
    sleep(0.7),
    write("################||| THANK YOU FOR USING ME, GOODBYE :) |||#####################"),nl,
    sleep(0.7),
    write('*******************************************************************************'),nl,
    write('-------------------------------------------------------------------------------'),nl,
    abort.

show_majors :-
    write('Here is a list of majors'),nl,nl,
    write('If you are a CS student, you can choose'),nl,
    write('1. Busines Information System \n2. Software Engineering \n3. Knowledge Engineering \n4. High Performance Computing'),nl,
    write('\nIf you are a CT student, you can choose'),nl,
    write('1. Computer Networking \n2. Embedded Systems\n'),nl.
