import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { QuotationsService } from './quotations.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  title = 'Quotation-App';
  profileForm: FormGroup;
  currentUser: any;
  quotationsObject: any;
  quotationsList = [];
  showTable: boolean = false;

  constructor(private quotationService: QuotationsService) {

    this.profileForm = new FormGroup({
      name: new FormControl(),
      gender: new FormControl(),
      age: new FormControl(),
      points: new FormControl(),
      noClaims: new FormControl(),
      licenseNumber: new FormControl()
    });
  }


  submitClientData() {
    if (!this.profileForm.valid) {
      alert("Please enter valid values in every field!");
      return;
    }
    this.quotationService.postClientInformation(this.profileForm.value).subscribe((response) => {
      this.currentUser = response;

      this.quotationService.getQuotationsForCurrentClient(this.currentUser).subscribe((result) => {
        this.quotationsObject = result;
        this.quotationsList = this.quotationsObject["quotationList"]
        this.showTable = true;

      }, err => {
        console.log("ERROR FETCHING QUOTATIONS FROM SERVER: ", err);
        alert("ERROR FETCHING QUOTATIONS FROM SERVER! Check Console");
      });

    }, error => {
      console.log("ERROR POSTING CLIENT DATA TO SERVER: ", error);
      alert("ERROR POSTING CLIENT DATA TO SERVER! Check Console");
    });
  }

  clearForm() {
    this.showTable = false;
    this.profileForm.reset();
  }
}
