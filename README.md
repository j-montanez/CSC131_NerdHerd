
![OpenOscars](https://raw.githubusercontent.com/j-montanez/CSC131_NerdHerd/GUI/src/openoscars/resources/imgs/OpenOscarsWordmark.png)

This is the semester project by NerdHerd (Group 4) for CSC131 Fall 2020

For more information visit the website [Here](https://j-montanez.github.io/CSC131_NerdHerd/)

## NerdHerd Consists of:
- Jose Montanez (Dev Team)
- Evelyn Pikalov (Product Owner)
- Skyler Rader (Scrum Master)
- Alex Smith (Dev Team)
- Steven Tran (Dev Team)
- Phuc Truong (Dev Team)

## Minimum Project Deliverables
1. Product 
    - a. Must provide a REST endpoint that delivers a collection resource in JSON.
        - [Link to website and description on how to request the endpoint](https://j-montanez.github.io/CSC131_NerdHerd/findByName.html)
        - Request must be made to [http://localhost:8080/demo/findAllByYear?year=](http://localhost:8080/demo/findAllByYear?year=)
        
    - b. Must provide a REST endpoint that delivers a singleton resource in JSON.
        - [Link to website and description on how to request the endpoint](https://j-montanez.github.io/CSC131_NerdHerd/findByName.html)
        - Request must be made to [http://localhost:8080/demo/findByName?name=](http://localhost:8080/demo/findByName?name=)
        
    - c. Must provide a REST endpoint that allows search of 1 Oscar category and returns
         results containing the nominees in JSON.
        -  [Link to website and description on how to request the endpoint](https://j-montanez.github.io/CSC131_NerdHerd/findByOscar.html)
        -  Request must be made to [http://localhost:8080/demo/findByOscar?name=](http://localhost:8080/demo/findByOscar?name=)
        
    - d. Must provide a minimum level of documentation regarding access, input and
         output to your API endpoints.
        - [Refer to our website for documentation](https://j-montanez.github.io/CSC131_NerdHerd/findByName.html) 
2. Process
    - a. Must have a product vision
        - Product Vision can be found [here](https://cdn.discordapp.com/attachments/760733386296918021/768260746597236766/ProductVisionDocument_FINAL_2.0.pdf)
    - b. Must have one persona
        - Persona can be seen in the [product vision document](https://cdn.discordapp.com/attachments/760733386296918021/768260746597236766/ProductVisionDocument_FINAL_2.0.pdf) for 2a or Non-minimum requirement 2c
    - c. Must store source code in a repository such as Github.com or Gitlab.ecs.csus.edu
        - You are currently on the GitHub repository for this requirement. [GitHub](https://github.com/j-montanez/CSC131_NerdHerd)
    - d. Must use Flying Donut to track and adhere to Scrum process.
        - We have used Flying Donut to track and adhere to Scrum. We have used a product backlog with stories, we have used story points to estimate stories, and we have used hours estimation for tasks.
    - e. Must implement AT LEAST one user story per sprint.
        - We have implemented at multiple stories per sprint from the backlog and assigned tasks to developers.
    - f. Must incorporate unit testing for a minimum of 2 classes.
        - We will go over this during the presentation. Documentation is on FlyingDonut. 
3. Presentation
    - a. Presentation details will be discussed toward the end of the semester however
         all team members must participate in the oral project presentation.
         - [Slides](https://docs.google.com/presentation/d/1PvjoM2NymyUTKuJzYLf4mcOS6xHwCf_nWy43PIYbw0I/edit?usp=sharing)
         - Demo and discussion to be done during class.

## Non-Minimum Project Deliverables

1. Product
    - a. The results returned contain data which correlates the Oscar category results with additional data from an outside source such as OMDB, TMDB, TVDB etc. by providing a link to an external site for the movie.
        - [We will demonstrate this feature during the presentation.](https://j-montanez.github.io/CSC131_NerdHerd/findByOscar.html) 
    - b. The search feature allows limiting results a to date range.
        - [We will demonstrate this feature during the presentation.](https://j-montanez.github.io/CSC131_NerdHerd/findAllByYear.html) 
    - c. More than one category can be searched.
        - We will demonstrate this feature during the presentation. 
    - d. More than one endpoint that delivers a collection resource.
        - [We will demonstrate this feature during the presentation.](https://j-montanez.github.io/CSC131_NerdHerd/findAllByYear.html) 
    - e. More than one endpoint that delivers a singleton resource.
        - [We will demonstrate this feature during the presentation.](https://j-montanez.github.io/CSC131_NerdHerd/findByName.html) 
    - f. Graphical user interface (GUI) for the product (or portions thereof).
        - The code for the GUI is in this repository, but we will demonstrate it during our presentation.     
    - g. Well-designed HTML page documenting API endpoints and example inputs/outputs.
        - [Website link](https://j-montanez.github.io/CSC131_NerdHerd/findByName.html)
2. Process
    - a. Incorporate test-driven development practice for one Sprint
        - We have not done this.
    - b. Refactor code in a significant manner with a clear and stated goal for refactoring.
        - The evidence is in our GitHub repo. The Gui specifically. 
    - c. Incorporate Contextual Inquiry/Elicitation techniques to create visual persona(s) and develop additional personas.
        - See .pdf download for Minimum Project Deliverables 2a
    - d. Create mockups for a proposed GUI (even if not implemented).
        - We have used Figma to create both wireframe [here](https://www.figma.com/file/aijPewFpVloOSW1jd7wF70/Wireframe?node-id=0%3A1) and high-fidelity prototype [here](https://www.figma.com/file/DRqOGx2Js0TGqy51L3y6Ov/High-Fidelity-Prototype)
    - e. Incorporate pair programming during one Sprint.
        - As evidenced by a 1 minute clip of a recorded in-person or Use Together session with link included in final deliverables.
        - We have done this [here](https://www.youtube.com/watch?v=OdL_c7lw_Zc).
    - f. Incorporate one or more design patterns.
        - We will point them out during our presentation.         
    - g. Adopt a coding standard and follow it
        - As evidence by its inclusion in the repository
        - We are using the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
    - h. Use a database to store and retrieve Oscar data using queries.
        - [Here's a screenshot of our database, further proof will be provided in demo](https://media.discordapp.net/attachments/760733386296918021/786443886536556564/unknown.png?width=768&height=376)        
    - i. Analyze Code using SonarQube or similar tool.
        - We did not do this.        
    - j. Product/REST service is publicly accessible via HTTP
        - [Resquests need to be sent here](https://j-montanez.github.io/CSC131_NerdHerd/findByName.html)        
    - k. Explain and document obstacles encountered during the project and how those
     obstacles were handled. Link can be found [here](https://docs.google.com/document/d/1HVMmpAKTPowrsNHPmgn8DHdnkKejtSkHEHKfmvwpvuQ/edit)
    - l. Incorporate a significant and descriptive diagram (use case, class, sequence,
     architecture, etc.) into analysis or design process. 
       
