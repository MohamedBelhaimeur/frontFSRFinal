import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ContactService } from 'src/app/contact.service';
import { NotificationService } from 'src/app/notification.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css'],
})
export class CreateComponent implements OnInit {
  formsearch: FormGroup;
  contact: c = {
    address: { city: '', country: '', street: '', zip: '' },
    contactGroups: [{ groupName: '' }],
    phones: [{ phoneKind: '', phoneNumber: '' }],
    email: '',
    lastName: '',
    firstName: '',
  };
  successrequest = false;
  constructor(
    private formBuilder: FormBuilder,
    private contactService: ContactService,
    private toastr: NotificationService
  ) {}

  ngOnInit(): void {
    this.formsearch = this.formBuilder.group({
      firstName: '',
      lastName: '',
      email: '',

      zip: '',
      street: '',
      country: '',
      city: '',

      phoneKind: '',
      phoneNumber: '',

      groupName: '',
    });
  }

  onSubmit() {
    this.contact.firstName = this.formsearch.get('firstName')!.value;
    this.contact.lastName = this.formsearch.get('lastName')!.value;
    this.contact.email = this.formsearch.get('email')!.value;
    this.contact.contactGroups[0].groupName =
      this.formsearch.get('groupName')!.value;
    this.contact.phones[0].phoneNumber =
      this.formsearch.get('phoneNumber')!.value;
    this.contact.phones[0].phoneKind = this.formsearch.get('phoneKind')!.value;
    this.contact.address.country = this.formsearch.get('country')!.value;
    this.contact.address.zip = this.formsearch.get('zip')!.value;
    this.contact.address.city = this.formsearch.get('city')!.value;
    this.contact.address.street = this.formsearch.get('street')!.value;
    console.log(this.contact);
    if (this.formsearch.get('firstName') != null) {
      this.contactService.postContact(this.contact).subscribe((data) => {
        console.log(data);
        this.successrequest = true;
        this.toastr.showSuccess('Contact ajouté avec succès', 'Ajout');
      });
    }
  }
}

export interface c {
  firstName: String;
  lastName: String;
  email: String;
  address: {
    zip: String;
    street: String;
    country: String;
    city: String;
  };
  phones: [
    {
      phoneKind: String;
      phoneNumber: String;
    }
  ];
  contactGroups: [
    {
      groupName: String;
    }
  ];
}
