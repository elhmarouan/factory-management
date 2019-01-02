import { ErrorHandler, Injectable } from '@angular/core';

@Injectable()
export class CustomErrorHandler implements ErrorHandler {
  constructor() {}
  handleError(error) {
    // your custom error handling logic
    console.log(error.error.message);
    alert('Une erreur technique est survenue : '+error.error.message);
  }
}