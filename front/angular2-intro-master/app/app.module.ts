import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import {HttpModule} from '@angular/http';
import { HttpClientModule } from '@angular/common/http';

import {Injectable} from '@angular/core';





import {InMemoryWebApiModule} from "angular-in-memory-web-api";
import {InMemoryDataService} from "./shared/data.service";


import {AppComponent} from './app.component';
import {TodoFormComponent} from "./todo-form/todo-form.component";
import {TodoListComponent} from "./todo-list/todo-list.component";
import {TodoItemComponent} from "./todo-item/todo-item.component";
import{TodoService} from "./shared/todo.service";





@NgModule({
    imports: [BrowserModule,
        Injectable,
        HttpModule,
        FormsModule,
        HttpClientModule,
        InMemoryWebApiModule.forRoot(InMemoryDataService)]
    ,
    declarations: [AppComponent,
        TodoFormComponent,
        TodoListComponent,
        TodoItemComponent],
    providers: [TodoService],
    bootstrap: [AppComponent],
})

export class AppModule {
    title = 'testAngular';
}
