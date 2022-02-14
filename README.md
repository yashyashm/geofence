1. Assumption
   a. Contract between front end and back end is provided and finalized in InputSchema.json
   b. AdvertOutpurSchema is the result of "Check for geofence Entrance"
   c. there can be multiple links associated with one latitude and logitude.

2. Flow is
    GeofenceController -> GeofenceService -> DatabaseService -> databse.
3. Database i used is sql.
4. Enpoints
    a. To create new geofence     http://localhost:8081/geofence
        {
            "latitude": 11.11,
            "longitude": 22.11,
            "radius" : 123,
            "link": ["https://www.google.com"]
        }

        Response
           Success
     b.  To get advert link for a geofence     http://localhost:8081/geofence
                 {
                     "latitude": 11.11,
                     "longitude": 22.11
                 }
        Response
                 [
                     {
                         "radius": 123.0,
                         "link": "https://www.google.com"
                     }
                 ]
    c. To manage geofence     http://localhost:8081/geofence/manage
        {
            "latitude": 11.11,
            "longitude": 22.11,
            "radius" : 123,
            "link": ["https://www.google.com"]
        }

        Response - status ok.
