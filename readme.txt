Conrad Markiewicz
CS342
HW #3

To use the program:
-Extract the contents of the zip file into an empty directory.
-Type "make" into the command line and hit enter.
-Type "java ExamTester" into the command line and hit enter.

The Exam tester will prompt the user for a file name for both the input exam files and output exam and student answer files.  These should all save in the same directory as the source files.

Please see below for a rundown of each class as well as their attributes & methods:
ExamTester - The driver program for this assignment.  As outlined above, will generate a sample exam and ask you for some answers.
Exam - The main class for exams:
	questions: A dynamic array of Question objects.
	description: The title of the exam.
	count: A running count of the number of questions currently in the exam.
	total: A running maximum number that the questions array is able to hold, dynamic grows as you add questions.
	Exam(String d): A constructor that initializes the description to the string object d.  Other attributes are set to defaults by the language.
	Exam(Scanner input): A constructor that takes an input stream as its input and generates an exam.
	print():Prints the title of the exam, plus all questions & answers.
	addQuestion(Question q):Adds question q to the questions array.
	reorderQuestions(): Randomly reorders the questions in the questions array.
	reorderMCAnswers(): If the question is of the type MCQuestion or its children, will randomly reorder its answers.
	getAnswerFromStudent(int pos): Gets the student's answer from user input.  Specify which question to answer with an integer.
	getValue(): Returns the current score in the exam.
	reportQuestionValues(): Creates a report of the current score of the exam as well as the current score of each question.
	save(PrintWriter output): Saves the current exam to the provided output stream.  Can be any stream, but a file is ideal.
	saveStudentAnswer(PrintWriter output): Saves the currently saved student answers to the output stream.  Can be any stream, but a file is ideal.
	restoreStudentAnswer(PrintWriter output): Loads student answers from the provided stream, best used with an input file.
Question - The main class for questions, is abstract:
	description: The actual question itself.
	rightAnswer: An answer object corresponding to the correct answer.
	studentAnswer: An answer object corresponding to the student's chosen answer.
	maxValue: A double containing the total value the question is worth.
	Question(): A default constructor for the question class.  Default values are given for non-object types, objects are made null.
	Question(String d, double mVal): Initializing constructor, sets the description to d and maxValue to mVal.
	Question(Scanner input): Initializes a question using the provided input stream.  Best used with files.
	clone(): A clone method, returns a deep copy of the calling question object.
	print(): An empty function, to be replaced by print functions in child classes of Question.
	setRightAnswer(Answer a): Sets the current rightAnswer attribute to a deep copy of the provided answer a.
	getMax(): Returns the maxValue attribute.
	getNewAnswer(): Abstract method for creating a corresponding answer object of the calling question type.
	getAnswerFromStudent(): Abstract method for getting an answer from user input.
	getValue(): Abstract method for returning the current value of the question.
	reorderAnswers(): Abstract method for randomly reordering the answers of any multiple-choice questions.  Non MC questions will want to give an error.
	save(): Saves the question to the provided input stream.  Best used with files.
	saveStudentAnswer(): Saves the student's current answers to a stream, usually a file.
	restoreStudentAnswer(): Loads a student's answers from a stream, usually a file.
MCQuestion - A child class of Question that handles multiple-choice questions, also abstract:
	answers: A dynamic array of Answer objects.
	count: A running count of the number of answers in the answers array.
	total: The current maximum the answers array is capable of holding.  Grows dynamically.
	MCQuestion(String d, double mVal): Initializes a Multiple-choice question object with d as the description and mVal as the maxValue, all others are default.
	MCQuestion(Scanner input): Initializes a MCQuestion object and loads its parameters from a file.
	print(): Prints the question text as well as the answers.
	addAnswer(Answer newAnswer): Adds a new answer to the answers array.
	reorderAnswers(): Randomly reorders the answers in the answers array.
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
Answer - A base class for answers of all types, is abstract:
	description: The answer text.
	Answer(): A default constructor for the Answer object, all values are set to defaults by Java.
	Answer(Scanner input): Instantiates an Answer object and loads data from the provided stream.
	clone(): An abstract method for cloning the calling Answer object.
	print(): An abstract method to print the answer text.
	getCredit(Answer rightAnswer): Returns the current score of the answer, depending on whether it matches the rightAnswer object given.
	getValue(): Abstract method to get the value of the answer.
	setSelected: Abstract method to set the selected state of child answer objects.
	setDescription: Sets the description of the Answer object.
	getDescription: Returns the answer text in description.
	save(): Abstract method in order to save currently held data to file.
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
ScannerFactory - A class that provides keyboard input for driver programs.
	keyboardScanner: A scanner object for use with user input from a keyboard.
	getKeyboardScanner: If keyboardScanner is not yet instantiated, then it is instantiated and returned to the caller.