import {Component} from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map';

@Component({
    selector: 'app',
    template: `<h1>Hello {{ name }}!</h1>
    <button (click)=doGet()>Velo</button>
    <li *ngFor="let rsuser of datos">
	  {{ rsuser }}
	</li>
    <input #title type="text"  />
    <span>{{ title.value }}</span>`
})
export class AppComponent {
    name: string;
    datos: RsUser;

    constructor(private http:Http) {
        this.name = 'Angular 2';
    }

    /*doGet() : any {
    	const url = `http://localhost:16535/RSTaskManager-war/rest/rsusers`;
    	return this.http.get(url)
    		.toPromise()
    		.then(response => {
    			this.datos = response.json();
    		})
    		.catch(this.handleError);

    }*/

    doGet() : any {
        const url = `http://localhost:16535/RSTaskManager-war/rest/rsusers`;
        return this.http.get(url)
            .map(response => response.json())
            .subscribe(result => this.datos = result.json());

    }

    private handleError(error: any): Promise<any> {
		console.error('An error occurred', error); // for demo purposes only
		return Promise.reject(error.message || error);
	}
}

class RsUser{
	id: number;
	name: string;
}