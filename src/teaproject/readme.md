PROJECT DONE BY:
Ozan Bolulu, 23070006045 Section 1

hello! this is the readme of the project-- I had a lot of fun making it and it was fun to try and 
experiment with new techniques. I've been interested in state machines for a while now because of
my interest in NPC AI in games aside from them being used a lot in them compared to some other fields.
I tried to aim for minimal garbage collection in this project by not creating and destroying the states
on every usage but instead creating a dictionary of reusable states with the help of the state enum.
Although this is what I also use in personal projects, it's probably way easier to just create/destroy states to be honest..
BUT!! it was really fun to think about and execute. the way the state machine is built allows me to create new state machines with
different states really easily by just creating a new enum and corresponding states. I don't even need to implement the subjects anymore for it-- if needed,
other classes can just implement observer interface like done here to access any and all state machines and subscribe to them. I think it's pretty neat :)

To run the project, use the following sql command to create the logs table:

---
CREATE TABLE logs (
id INT AUTO_INCREMENT PRIMARY KEY,
cups INT NOT NULL,
made_at TIMESTAMP NOT NULL
);
---

the database connection info is using default values with TeaDatabaseLogger, but you can change the values in it if needed.
I didn't feel the need to create a config file for these since values arent that secret and that its a local database, plus I didnt
make the sql commands in the database Logger into enums with their corresponding statements like last year's project since I'm not sure
if that's such a better idea than just doing this. that always felt like a bit too much seperation since the databaseLogger is already directly interacting with the database,
So was never sure if it was necessary to seperate the commands themselves from the function with enums.