### Pets Server
- Small Demo server to handle a PetsServer.
- Information is currently not persisted across sessions. 
- Validation with a key / header is not necessary. Still TBD on a timeframe.

[Pet] Contains all the data required for a successful interaction. 

### Routes:
- GET
  - /pet : Gives back all the stored pets information
    - If no pets are stored, it responds with an OK code and a "No pets found" message.
  - /pet/{id?}      Gives back the pet associated with such id. 
    - Will return "BadRequest" when request is missing the id
    - Will return "NotFound" when the id is not found among the available pets.
    - Otherwise, the call succeeds.


- POST
  - /pet : Attempts to save the passed Pet information. 
    - If the data is not formatted properly, a "BadRequest" response is sent. 
    - If the ID of the pet is already present, a "Conflict" is given back. 
    - Otherwise, the call succeeds.


- DELETE
  - /pet/{id?} : Attempts to remove the data associated with a given Pet ID. 
    - If the ID is missing, throws a "BadRequest". 
    - If the id is not found, it answers with "NotFound".
    - Otherwise, the call succeeds.
