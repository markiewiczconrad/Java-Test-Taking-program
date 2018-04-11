Conrad Markiewicz
CS342
HW #4
Group members: Kashyapkumar Trivedi & Jay Patel

Division of labor is as follows:
- I was responsible for division 1 as outlined in the assignment writeup as well as the ExamTaker class.
- Kashyapkumar was responsible for division 2, as well as the ExamBuilder class.
- Jay was responsible for division 3 and the ExamGrader class.
- As of this writing, Jay Patel was unable to complete his portion of the HW and the classes are a mixture of mine and Kashyapkumar's.

To use the program:
-Extract the contents of the zip file into an empty directory.
-Type "make ExamTaker" into the command line and hit enter.
-Type "java ExamTaker" into the command line and hit enter.

The Exam taker will prompt the user for a file name for the exam file, ask the user to choose which questions to answer, provide answers and ask the user for the location of the answer file.  You can provide a full path to the file.
If no path is provided, the file will be saved to the root directory of the directory the classes are located.

Please see below for a rundown of each class as well as their attributes & methods:
ExamTaker - The driver program for this assignment.  As outlined above, will generate an exam from a source file and ask you to answer the questions.
Exam - The main class for exams:
	questions1: A dynamic ArrayList of Question objects.
	text: The title of the exam.
	reportQuestionTotal: Used with the reportQuestionValues method, stores the total score.
	Exam(String exam): A constructor that initializes the description to the string object d.  Other attributes are set to defaults by the language.
	Exam(Scanner EDF): A constructor that takes an input stream as its input and generates an exam.
	print():Prints the title of the exam, plus all questions & answers.
	addQuestion(Question q):Adds question q to the questions array list.
	removeQuestion(int question): Removes the question located in position question in the array list.
	reorderQuestions(): Randomly reorders the questions in the questions array.
	reorderMCAnswers(): If the question is of the type MCQuestion or its children, will randomly reorder its answers.
	getAnswerFromStudent(int pos): Gets the student's answer from user input.  Specify which question to answer with an integer.
	getValue(): Returns the current score in the exam.
	reportQuestionValues(): Creates a report of the current score of the exam as well as the current score of each question.
	save(PrintWriter writeInFile): Saves the current exam to the provided output stream.  Can be any stream, but a file is ideal.
	saveStudentAnswer(PrintWriter writeInFile): Saves the currently saved student answers to the output stream.  Can be any stream, but a file is ideal.
	saveStudentAnswer(PrintWriter writeInFile, String sourceFile): Saves the currently saved student answers to the output stream, includes the path of the exam file to compare it to.  Can be any stream, but a file is ideal.
	restoreStudentAnswer(PrintWriter output): Loads student answers from the provided stream, best used with an input file.
Question - The main class for questions, is abstract:
	text: The actual question itself.
	rightAnswer: An answer object corresponding to the correct answer.
	studentAnswer: An answer object corresponding to the student's chosen answer.
	maxValue: A double containing the total value the question is worth.
	fordouble: A double containing the total value of the question.
	Question(): A default constructor for the question class.  Default values are given for non-object types, objects are made null.
	Question(String message, double maxValue): Initializing constructor, sets the description to d and maxValue to maxValue.
	Question(Scanner quesFile): Initializes a question using the provided input stream.  Best used with files.
	print(): Prints the question.
	setRightAnswer(Answer a): Sets the current rightAnswer attribute to a deep copy of the provided answer a.
	getNewAnswer(): Abstract method for creating a corresponding answer object of the calling question type.
	getAnswerFromStudent(): Abstract method for getting an answer from user input.
	getValue(): Abstract method for returning the current value of the question.
	save(): Saves the question to the provided input stream.  Best used with files.
	saveStudentAnswer(): Saves the student's current answers to a stream, usually a file.
	restoreStudentAnswer(): Loads a student's answers from a stream, usually a file.
MCQuestion - A child class of Question that handles multiple-choice questions, also abstract:
	questions2: A dynamic array list of Answer objects.
	MCQuestion(String text, double maxValue): Initializes a Multiple-choice question object with d as the description and mVal as the maxValue, all others are default.
	MCQuestion(Scanner quesFile): Initializes a MCQuestion object and loads its parameters from a file.
	print(): Prints the question text as well as the answers.
	addAnswer(MCAnswer mcans): Adds a new answer to the answers array.
	reorderAnswers(): Randomly reorders the answers in the answers array.
	getValue(MCAnswer ans): Returns the value of the current question.
	save(): Abstract method to save the current question to an output stream, usually a file.
MCSAQuestion - A child class of MCQuestion that handles multiple-choice, single-answer questions:
	MCSAQuestion(): A default constructor for MCSAQuestions, all values are initialized to their defaults by Java.
	MCSAQuestion(String d): An initializing constructor that initializes description to d.
	MCSAQuestion(MCSAQuestion q): A copy constructor, creates a deep copy of q.
	MCSAQuestion(Scanner input): Initializes an MCSAQuestion object and loads its data from an input stream, usually a file.
	clone(): A clone method for the MCSAQuestion class, returns a deep copy of the calling object.
	getNewAnswer(): Returns a MCSAAnswer for later addition into a MCSAQuestion object.
	getAnswerFromStudent(): Asks the user to choose from the available answers from the command line.  Sets that answer as the studentAnswer attribute.
	getValue(): Returns the current value of the question, based on the answer given by the student.
	save(PrintWriter output): Saves data to an output stream, usually a file.
	saveStudentAnswer(PrintWriter output): Saves the student's currently saved answers to file.
	restoreStudentAnswer(Scanner input): Loads student answers from file.
MCMAQuestion - A child class of MCQuestion that handles multiple-choice, multiple-answer questions:
	studentAnswers: A dynamic array containing answer objects corresponding to the student's given answers.
	base: A double containing the base value of the question, if no answers are circled.
	scount: The current total number of answers contained within studentAnswers.
	stotal: The total number of answers that studentAnswers is capable of holding.
	MCMAQuestion(String d, double mVal, double b): Initializes an MCMAQuestion object using the provided data.
	MCMAQuestion(Scanner input): Instantiates an MCMAQuestion object and loads data from the provided input stream.
	MCMAQuestion(MCMAQuestion q): Copy constructor; creates a deep copy of the provided MCMAQuestion object.
	getNewAnswer(): Creates and returns a new MCMAQuestion object.
	getNewAnswer(String d, double b): Creates and initializes a new MCMAQuestion object with the provided data, before returning it.
	getValue(): Returns the value of the question according to the answers provided by the student.
	save(PrintWriter output): Saves data to an output stream, usually a file.
	saveStudentAnswer(PrintWriter output): Saves the student's currently saved answers to file.
	restoreStudentAnswer(Scanner input): Loads student answers from file.
	clone(): Creates a deep copy of the calling object.
	getAnswerFromStudent(): Prompts the student for answers, will continue until the student has selected all desired answers.
	getValue(MCAnswer a): Returns the value when compared to the provided answer.
SAQuestion - A child class of Question, for short-answer questions:
	SAQuestion(): Default constructor, initializes all attributes to defaults by Java.
	SAQuestion(String d): Initializing constructor, initializes description to d.
	SAQuestion(SAQuestion a): Copy constructor, creates a deep copy of a.
	SAQuestion(Scanner input): Instantiates the SAQuestion object and loads its data from the provided input stream.
	clone(): Clone method, returns a deep copy of the calling object.
	print(): Prints the question description and its currently inputted answer.
	getNewAnswer(): Returns a blank SAAnswer object for later re-insertion into a SAQuestion object.
	getAnswerFromStudent(): Takes input from the student and sets it to the studentAnswer attribute.
	reorderAnswers(): Gives a joke error message, otherwise does nothing.
	getValue(): Gets the value of the question based on the student's answer.
	save(PrintWriter output): Saves the object's data to the provided file.
	saveStudentAnswer(PrintWriter output): Saves the currently selected student answer to the provided stream.
	restoreStudentAnswer(Scanner input): Loads student answers from the provided stream.
NumQuestion - A child class of Question, for numerical (double) answers.
	NumQuestion(): Default constructor, initializes all attributes to defaults by Java.
	NumQuestion(String d): Initializing constructor, initializes description to d.
	NumQuestion(SAQuestion a): Copy constructor, creates a deep copy of a.
	NumQuestion(Scanner input): Instantiates the SAQuestion object and loads its data from the provided input stream.
	clone(): Clone method, returns a deep copy of the calling object.
	print(): Prints the question description and its currently inputted answer.
	getNewAnswer(): Returns a blank SAAnswer object for later re-insertion into a SAQuestion object.
	getAnswerFromStudent(): Takes input from the student and sets it to the studentAnswer attribute.
	reorderAnswers(): Gives a joke error message, otherwise does nothing.
	getValue(): Gets the value of the question based on the student's answer.
	save(PrintWriter output): Saves the object's data to the provided file.
	saveStudentAnswer(PrintWriter output): Saves the currently selected student answer to the provided stream.
	restoreStudentAnswer(Scanner input): Loads student answers from the provided stream.
Answer - A base class for answers of all types, is abstract:
	selection: Controls whether the answer is currently selected or no.
	Answer(): A default constructor for the Answer object, all values are set to defaults by Java.
	Answer(Scanner ans): Instantiates an Answer object and loads data from the provided stream.
	print(): An abstract method to print the answer text.
	getCredit(Answer rightAnswer): Returns the current score of the answer, depending on whether it matches the rightAnswer object given.
	save(PrintWriter ans): Abstract method in order to save currently held data to file.
MCAnswer - An abstract child class of Answer for multiple-choice answers:
	description: The answer text.
	selected: A boolean containing the current selection status of the answer, whether it is the currently selected answer or not.
	MCAnswer(): Default constructor for an MCAnswer object, all attributes are set to defaults by Java.
	MCAnswer(String d): Initializing constructor that sets description to d.
	MCAnswer(String d, double cred): Initializes a new MCAnswer object with the provided data.
	MCAnswer(Scanner input): Initializes a new MCAnswer object with data from the provided input stream.
	print(): Prints the text of the answer.
	setSelected(boolean s): Sets the current selected attribute of the answer to s.
	getDescription(): Returns the answer text as a String.
	save(PrintWriter output): Saves the object's data to the provided stream.
MCSAAnswer - A child class of MCAnswer for multiple-choice, single-answer questions:
	MCSAAnswer(): Default constructor, initializes all attributes to defaults by Java.
	MCSaAnswer(String d): Constructor that initializes description to the given string d and the selection status to false.
	MCSAAnswer(MCSAAnswer a): Copy constructor, creates a deep copy of a.
	MCSAAnswer(String d, double cred): Initializes a new MCSAAnswer object with the provided data.
	MCSAAnswer(Scanner input): Initializes a new object with data from the provided stream.
	clone(): Clone method, returns a deep copy of the calling object.
	getCredit(): Returns the value of the answer depending on if it matches the rightAnswer.
	getValue(): Returns the value of the answer.
	getDescription(): Returns the description of the calling ansewr.
MCMAAnswer - A child class of MCAnswer, for multiple-choice, multiple-answer questions:
	MCMAAnswer(): Default constructor, initializes all variables to defaults.
	MCMAAnswer(MCMAAnswer a): Copy constructor, creates a deep copy of the provided MCMAAnswer a.
	MCMAAnswer(String d): Initializes a new MCMAAnswer with the provided data.
	MCMAAnswer(String d, double cred): Initializes a new MCMAAnswer with the provided data.
	MCMAAnswer(Scanner input): Initializes a new MCMAAnswer with the provided input stream.
	clone(): Provides a deep copy of the calling MCMAAnswer object.
	getCredit(Answer rightAnswer): Returns the current value of the answer based on its relation to rightAnswer.
	getValue(): Returns the current credit of the answer.
	getDescription(): Returns the description of the answer.
SAAnswer - A child class of Answer for short-answer quesion answers.
	description: The answer's text.
	SAAnswer(): Default constructor, initializes all attributes to their defaults by Java.
	SAAnswer(String d): Constructor that initializes description to d.
	SAAnswer(SAAnswer a): Copy constructor that creates a deep copy of object a.
	SAAnswer(Scanner input): Initializes a new SAAnswer object with data provided by the input stream.
	clone(): Clone method, returns a deep copy of the calling object.
	print(): Prints the current text of the answer.
	getCredit(Answer rightAnswer): Returns the value of the answer based on whether it matches the given rightAnswer object.
	getValue(): Returns the current value of the object.
	getDescription(): Returns the answer text.
	setSelected(): Gives an error stating this method is for multiple-choice questions.  Do not use.
	save(): Saves the current data of the answer to the provided output stream.
NumAnswer - A child class of Answer for numerical (double) answers.
	value: The answer's value.
	NumAnswer(): Default constructor, initializes all attributes to their defaults by Java.
	NumAnswer(double v): Constructor that initializes description to v.
	NumAnswer(NumAnswer a): Copy constructor that creates a deep copy of object a.
	NumAnswer(Scanner input): Initializes a new NumAnswer object with data provided by the input stream.
	clone(): Clone method, returns a deep copy of the calling object.
	print(): Prints the current text of the answer.
	getCredit(Answer rightAnswer): Returns the value of the answer based on whether it matches the given rightAnswer object.
	getCredit(Answer rightAnswer, double tolerance): Returns the value of the answer based on whether it matches the given rightAnswer object within the given tolerance.
	getValue(): Returns the current value of the object.
	getDescription(): Returns the answer text.
	setSelected(): Gives an error stating this method is for multiple-choice questions.  Do not use.
	save(): Saves the current data of the answer to the provided output stream.
ScannerFactory - A class that provides keyboard input for driver programs.
	keyboardScanner: A scanner object for use with user input from a keyboard.
	getKeyboardScanner: If keyboardScanner is not yet instantiated, then it is instantiated and returned to the caller.