import {InMemoryDbService} from "angular-in-memory-web-api";


export class InMemoryDataService implements InMemoryDbService{
    createDb(){
        const todos = [
            {
                title: 'Netflix',
                completed: true
            },
            {
                title: 'World of Warcraft',
                completed: false
            },
            {
                title: 'Play музыка' +
                    '',
                completed: true
            }
        ];

        return{ todos};

    }

}
