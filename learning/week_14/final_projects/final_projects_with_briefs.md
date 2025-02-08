# Final Projects

## Brief


* Create your own brief **OR** go with a pre-written brief (below) ?✅
* Chat and share your project ideas in slack and at our project sharing session on Monday afternoon in the classroom zoom. ✅
* Start working on your projects next Friday (or Thursday if you're ready)
* Send the instructors your repo' links!
  * Add your brief into the root README.md file for the repo. 
  * One repo for your entire project
* Work until Wednesday or Thursday (if you dare - just make sure it works for the pres' 😉 )
* Presentations on Thursday/Friday(depending on the number of groups) - **please send us your song**
* Choose your own team - no bigger than 4 + **no repeated teams from previous projects**
* Solo is an option - by all means

## Rules

### Tech

* Choose your own tech stack - but we **strongly** encourage full stack with Java on the back-end. 
* We heavily encourage 3rd party libraries of all kinds for JS or Java - you choose. Explore some ideas - we're **really** keen to see what you find. If you do, it makes a great topic for the presentation. Examples include ( see "awesome" lists below for even more inspiration )
  * MongoDB for JPA
  * Reactive for Spring Boot
  * Socket.IO / RSocket / WebSockets etc
  * Semantic UI for React
  * Bootstrap for React
  * Styled Components for React
* Be careful with things like ReactNative and Swift - they are fun but can often take longer to build with than we have time for. 


## Project Ideas

If you go with your own idea you must:

* Complete a brief that details the MVP and extensions.
* Be extremely careful to not bite off more than you can handle - but being adventurous 
* Show it to instructors for sign-off


### Notice Board

If you (individually) have an idea for a project and would like to be in a group, we'd love it if you could advertise or pitch your idea to recruit other students to your project. Sell your idea and be open to suggestions on how it could be mixed around and changed. **We would love to see a hive of activity on slack discussing this  - get pitching :D**

Even if you don't have an idea, but maybe want to work on a particular technology or library - please bring along your thoughts and share with others as there could be a really good match. Tell people what tech you want to work on if there's something that takes your fancy  and feel free to share that on slack, too.


--

## Custom Project Extensions

* Use an external API - but not allowed to call it from your client. You can use an external API but only if you pull the data into your own back-end and use it from there. (exceptions are things like stripe, twilio, sendgrid)



## Project Tech Exploration Ideas



- <https://github.com/enaqx/awesome-react> - An excellent curated list of awesome react libraries.
- <https://github.com/phodal/awesome-iot-projects> - A curated list of awesome IoT projects and ideas.
- <https://github.com/akullpp/awesome-java> - An excellent curated list of awesome Java libraries.
- <https://github.com/sorrycc/awesome-javascript> - An excellent curated list of awesome JS libraries covering both front-end and back-end.
- [Docker](https://www.docker.com/) - A tool for allowing you to package up your app into a container.


### APIs

- [twilio](https://www.twilio.com/) - A platform that has production-grade instant messaging and video conferencing API’s.
- [Stripe](https://stripe.com/) - A platform for adding payment for almost any payment type or currency to your app. Has API’s and libraries for allowing payments, setting up subscriptions etc. Also has extremely good developer mode that means you can “pay” for stuff in your app with fake card details and see it work the way it would in production.
- [Sendgrid](https://sendgrid.com/)  -  Platform (owned by Twillio, actually) for allowing you to generate and send emails via API. Has libraries for most languages.
- [Grafana](https://grafana.com/)- Tool for creating visualisations of data for analytics / monitoring purposes



--
--

# Pre-written project briefs

## SGNN News

What'**s** **G**oi**n**' O**n** News have asked you to build a web application to allow them to upload the latest Scottish news.

They want to be able to:

- Add, Edit and Remove Journalists
- Add, Edit and Remove Articles

For the front end of the website, users should be able to:

- View a list of articles, ordered by date. (Newest first!)
- Filter articles based on catagory
- Click through to the full story

(Each Article might have a headline, summary paragraph, and the full story along with the journalist who wrote it - and any other fields you want to add.)

## Project Extensions

- Search for articles where the title includes a particular search term
- Filter articles by journalist
- Filter articles by category, which can be added by SGNN
- Track how many times an article has been read, and display a list of most popular articles
- _Paginate_ your article list - display a certain number of articles per page, with a page number, and navigation to go to the next and previous page

And other any extensions you would like to add.

## Restaurant Booking System:

You have been tasked to create a booking system for a brand new restaurant. The restaurant needs a way to book and arrange tables for customers who are booking over the phone. This system is for the staff to use.

### MVP:

Your system must be able to:

* Allow a customer to book a table at the restaurant for a particular time and date
* Update a booking, for example if the customer wants to change a booking time
* Display a list of bookings for a given date
* Display a list of customers ordered by frequency of visits

### Project Extensions:

* Don't allow double bookings
* Add a customer's receipt to a booking so you can view their previous orders and how much they spent
* Calculate how much a customer has spent over a given period of time
* Give discounts to frequent customers
* Whatever features you think would be beneficial to a restaurant
