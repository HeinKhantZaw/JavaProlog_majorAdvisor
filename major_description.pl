info(business_information_system):-
	write("\n\nBIS is a set of inter-related procedures using IT infrastructure in a business enterprise to generate and disseminate desired information").

info(software_engineering):-
	write("\n\nSE is a process of analyzing user requirements and then designing, building, and testing software application which will satisfy those requirements. ").

info(high_performance_computing):-
	write("\n\nHPC is the ability to process data and perform complex calculations at high speeds and the use of super computers and parallel processing techniques for solving complex computational problems").

info(knowledge_engineering):-
	write("\n\nKE is a field of AI, creating rules that apply to data in order to imitate the way a human thinks and approaches problems.").

info(computer_networking):-
	write("\n\nCN is an engineering discipline that aims to study and analyze the communication process among various computing devices or computer systems that are linked, or networked, together to exchange information and share resources.").

info(embedded_systems):-
	write("\n\nES is a combination of computer hardware and software, either fixed in capability or programmable, designed for a specific function or functions within a larger system.").

quit :-
	sleep(1.5),nl,
    write("\nEnter 0 to quit or 1 to start again : "),
    read(X),
    reconsult('main.pl'),
    (X = 0,
        clear,
        end_logo,
        abort()
        
    );
    (X = 1,
        clear,
        start
     ). 