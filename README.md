# TDJJ-COMP3050
Welcome to our project

Tech-Stack:
Java
Map stored via text file into memory
built-in Java HTTP server
Docker for containerisation

Basic project plan:
• The server maintains a tile-based map and tracks a player character’s position
• Two API endpoints:
– /move?dy=DY&dx=DX — move the character one space (N/S/E/W)
– /info?y=Y&x=X — return map tile data around a location
• The map is a grid of tile types (grass, walls, water, doors, etc.) — some tiles block movement
• The client displays an 11×11 view centred on the player
• The server stores the map as a text file loaded into memory
