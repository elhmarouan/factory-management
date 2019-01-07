import { ErrorHandler, Injectable } from '@angular/core';

@Injectable()
export class CustomErrorHandler implements ErrorHandler {
  constructor() {}
  handleError(error) {
    // your custom error handling logic
    console.log(error);
    if (error.error) {
      alert('Une erreur technique est survenue : '+error.error.message);
    } else if (error) {
      alert('Une erreur technique est survenue : '+error.message);
    }
    throw error;
  }
}