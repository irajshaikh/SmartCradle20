###### Installing maven on windows
https://www.javatpoint.com/how-to-install-maven

###### Run on local
`mvn spring-boot:run`

###### Push latest code on Heroku
`git push heroku master`

###### View deployed app
`heroku open`
This opens browser with URL: https://smartcradle20.herokuapp.com/

###### View logs from Heroku
`heroku logs --tail`

###### Other useful heroku commands
* `heroku git:remote -a smartcradle20`
* `heroku login`
* `heroku local web`

###### Run unit tests
`mvn test`

###### Updating data
`
curl --location --request POST 'https://smart-cradle.herokuapp.com/api/feed' \
--header 'Content-Type: application/json' \
--data-raw '{
    "temperature":37,
    "hasWetDiaper": true,
    "isCrying": false
}'
`

###### Getting data
`
curl --location --request GET 'https://smart-cradle.herokuapp.com/api/feed'
`