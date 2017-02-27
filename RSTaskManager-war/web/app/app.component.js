"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require("@angular/core");
var http_1 = require("@angular/http");
require("rxjs/add/operator/toPromise");
require("rxjs/add/operator/map");
var AppComponent = (function () {
    function AppComponent(http) {
        this.http = http;
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
    AppComponent.prototype.doGet = function () {
        var _this = this;
        var url = "http://localhost:16535/RSTaskManager-war/rest/rsusers";
        return this.http.get(url)
            .map(function (response) { return response.json(); })
            .subscribe(function (result) { return _this.datos = result; });
    };
    AppComponent.prototype.handleError = function (error) {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    };
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        selector: 'app',
        template: "<h1>Hello {{ name }}!</h1>\n    <button (click)=doGet()>Velo</button>\n    <li *ngFor=\"let rsuser of datos\">\n\t  {{ rsuser.name }}\n\t</li>\n    <input #title type=\"text\"  />\n    <span>{{ title.value }}</span>"
    }),
    __metadata("design:paramtypes", [http_1.Http])
], AppComponent);
exports.AppComponent = AppComponent;
var RsUser = (function () {
    function RsUser() {
    }
    return RsUser;
}());
//# sourceMappingURL=app.component.js.map